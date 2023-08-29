package linton.moreriders.handlers;

import linton.moreriders.items.FireworkStickBase;
import linton.moreriders.items.StickBase;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY_MORERIDERS = "key.category.moreriders.categoryone";
    public static final String KEY_RIDING_JUMP = "key.moreriders.riding_jump";

    public static KeyBinding ridingJumpKey;

    private static void processJumping(MinecraftServer server){
        if(!server.getPlayerManager().getPlayerList().isEmpty()){
            PlayerEntity player = server.getPlayerManager().getPlayerList().get(0);
            ItemStack itemStack = player.getMainHandStack();
            if(itemStack.getItem() instanceof StickBase || itemStack.getItem() instanceof FireworkStickBase){
                Entity vehicle = player.getVehicle();
                if(vehicle!=null){
                    vehicle.addVelocity(0,0.5,0);
                }
            }
        }
    }

    private static void registerKeyInputs(){
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if(ridingJumpKey.wasPressed()){
                processJumping(server);
            }
        });
    }

    public static void register(){
        ridingJumpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_RIDING_JUMP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_MORERIDERS
        ));
        registerKeyInputs();
    }
}
