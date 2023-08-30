package linton.moreriders.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static linton.moreriders.MoreRiders.ModID;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> GROUP1 = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ModID, "example"));

    public static void register(){
        Registry.register(Registries.ITEM_GROUP, GROUP1, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.INIT_WITH_FW))
                .displayName(Text.translatable( ModID+".group1"))
                .build()); // build() no longer registers by itself

        ItemGroupEvents.modifyEntriesEvent(GROUP1).register(content -> {
            content.add(ModItems.INIT_WITH_FW);
            content.add(ModItems.GOLDEN_CARROT_ON_A_STICK);
            content.add(ModItems.GOLDEN_CARROT_ON_A_STICK_WITH_FW);
            content.add(ModItems.EMERALD_ON_A_STICK);
            content.add(ModItems.EMERALD_ON_A_STICK_WITH_FW);
            content.add(ModItems.WHEAT_SEEDS_ON_A_STICK);
            content.add(ModItems.WHEAT_SEEDS_ON_A_STICK_WITH_FW);
            content.add(ModItems.WHEAT_ON_A_STICK);
            content.add(ModItems.WHEAT_ON_A_STICK_WITH_FW);
            content.add(ModItems.FLOWER_ON_A_STICK);
            content.add(ModItems.FLOWER_ON_A_STICK_WITH_FW);
            content.add(ModItems.SEAGRASS_ON_A_STICK);
            content.add(ModItems.SEAGRASS_ON_A_STICK_WITH_FW);
        });
    }
}
