package linton.moreriders.items;

import jdk.jshell.Snippet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireworkStickBase extends Item {
    public FireworkStickBase(Settings settings) {
        super(settings.maxDamage(50));
    }

    private final static double speedInc = 3.0;

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(user.getVehicle()==null){
            user.startRiding(entity);
        }
        return ActionResult.success(true);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

        if(user.getVehicle()!=null){
            Entity vehicle = user.getVehicle();
            vehicle.addVelocity(Vec3d.fromPolar(user.getPitch(),user.getYaw()).multiply(speedInc));
            if(!user.isCreative()){
                itemStack.setDamage(itemStack.getDamage() + 1);
            }
        }


        //add firework
        if(!world.isClient){
            FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world,itemStack,user);
            world.spawnEntity(fireworkRocketEntity);
            world.spawnEntity(fireworkRocketEntity);
            world.spawnEntity(fireworkRocketEntity);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
