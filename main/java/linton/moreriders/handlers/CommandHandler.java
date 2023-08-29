package linton.moreriders.handlers;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandHandler {
    public static void register(){
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("test")
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    player.sendMessage(Text.literal("你好，欢迎来到Fabric!"));
                    VillagerEntity villagerEntity = new VillagerEntity(EntityType.VILLAGER,player.getWorld());
                    player.getWorld().spawnEntity(villagerEntity);
                    villagerEntity.setPosition(player.getPos());
                    player.startRiding(villagerEntity,true);
                    return 1;
                })));
    }

}
