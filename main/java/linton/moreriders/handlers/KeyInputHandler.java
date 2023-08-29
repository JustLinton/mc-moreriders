package linton.moreriders.handlers;

import linton.moreriders.items.FireworkStickBase;
import linton.moreriders.items.StickBase;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY_MORERIDERS = "key.category.moreriders.categoryone";
    public static final String KEY_RIDING_JUMP = "key.moreriders.riding_jump";
    public static final String KEY_RIDING_DOWN_FLY = "key.moreriders.riding_down_fly";

    public static KeyBinding ridingJumpKey;
    public static KeyBinding ridingDownFlyKey;

    private final static long pressColdDownJumpTicks = 10;
    private final static long pressColdDownFlyTicks = 5;
    private final static double flyUpAcc = 0.15;
    private final static double flyDownAcc = -0.35;
    private final static double JumpUpAcc = 0.5;

    private static boolean judgeIfFlyable(Entity entity){
        return entity instanceof ChickenEntity || entity instanceof ParrotEntity;
    }


    private static long lastPressedTicks = 0;
    private static void jump(Entity vehicle, boolean fly){
        if(lastPressedTicks <= pressColdDownJumpTicks && !fly){
            return;
        }
        if(lastPressedTicks <= pressColdDownFlyTicks && fly){
            return;
        }
        lastPressedTicks = 0;
        vehicle.addVelocity(0, fly?flyUpAcc:JumpUpAcc,0);
    }

    private static void downFly(Entity vehicle){
        vehicle.addVelocity(0,flyDownAcc,0);
    }

    private static void processDownFlying(MinecraftServer server){
        if(!server.getPlayerManager().getPlayerList().isEmpty()){
            PlayerEntity player = server.getPlayerManager().getPlayerList().get(0);
            ItemStack itemStack = player.getMainHandStack();
            if(itemStack.getItem() instanceof StickBase || itemStack.getItem() instanceof FireworkStickBase){
                Entity vehicle = player.getVehicle();
                if(vehicle!=null){
                    if(judgeIfFlyable(vehicle)){
                        downFly(vehicle);
                    }
                }
            }
        }
    }

    private static void processJumping(MinecraftServer server){
        if(!server.getPlayerManager().getPlayerList().isEmpty()){
            PlayerEntity player = server.getPlayerManager().getPlayerList().get(0);
            ItemStack itemStack = player.getMainHandStack();
            if(itemStack.getItem() instanceof StickBase || itemStack.getItem() instanceof FireworkStickBase){
                Entity vehicle = player.getVehicle();
                if(vehicle!=null){
                    if(judgeIfFlyable(vehicle)){
                        jump(vehicle,true);
                    }else if(!vehicle.getWorld().getBlockState(vehicle.getBlockPos().add(0,-1,0)).isAir()){
                        jump(vehicle,false);
                    }
                }
            }
        }
    }

    private static void registerKeyInputs(){
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            lastPressedTicks = lastPressedTicks + 1;
            if(ridingJumpKey.wasPressed()){
                processJumping(server);
            }
            if(ridingDownFlyKey.wasPressed()){
                processDownFlying(server);
            }
        });
    }

    public static void register(){
        ridingJumpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_RIDING_JUMP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY_MORERIDERS
        ));
        ridingDownFlyKey= KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_RIDING_DOWN_FLY,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                KEY_CATEGORY_MORERIDERS
        ));
        registerKeyInputs();
    }
}
