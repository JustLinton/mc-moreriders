package linton.moreriders.handlers;

import linton.moreriders.items.EmeraldOnAStick;
import linton.moreriders.items.FireworkStickBase;
import linton.moreriders.items.StickBase;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class RiderHandler {

    //movement speed of riding
    static final double speedInc = 0.07;

    static boolean judgeIfApplicable(Item item, Entity vehicle){
        String itemClassName = item.getClass().getName();

        if(itemClassName.contains("GoldenCarrotOnAStick")){
            return true;
        }

        if(itemClassName.contains("EmeraldOnAStick")){
            return vehicle instanceof VillagerEntity;
        }

        if(itemClassName.contains("WheatSeedsOnAStick")){
            return vehicle instanceof ChickenEntity || vehicle instanceof ParrotEntity;
        }

        if(itemClassName.contains("WheatOnAStick")){
            return vehicle instanceof GoatEntity || vehicle instanceof CowEntity || vehicle instanceof SheepEntity;
        }

        if(itemClassName.contains("FlowerOnAStick")){
            return vehicle instanceof BeeEntity;
        }


        return false;
    }

    public static void register(){
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if(!server.getPlayerManager().getPlayerList().isEmpty()){
                PlayerEntity player = server.getPlayerManager().getPlayerList().get(0);
                ItemStack itemStack = player.getMainHandStack();
                if(itemStack.getItem() instanceof StickBase || itemStack.getItem() instanceof FireworkStickBase){
                    Entity vehicle = player.getVehicle();
                    if(vehicle!=null && judgeIfApplicable(itemStack.getItem(),vehicle)){
                        Vec3d direction = Vec3d.fromPolar(player.getPitch(),player.getYaw());
                        Vec3d horizonDirection = new Vec3d(direction.x,0,direction.z);
                        vehicle.addVelocity(horizonDirection.multiply(speedInc));
                        vehicle.setYaw(player.getYaw());
                    }
                }
            }
        });
    }

}
