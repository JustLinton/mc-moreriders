package linton.moreriders.items;

import linton.moreriders.MoreRiders;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GOLDEN_CARROT_ON_A_STICK = new GoldenCarrotOnAStick(new FabricItemSettings());
    public static final Item GOLDEN_CARROT_ON_A_STICK_WITH_FW = new GoldenCarrotOnAStickWithFW(new FabricItemSettings());
    public static final Item EMERALD_ON_A_STICK = new EmeraldOnAStick(new FabricItemSettings());
    public static final Item EMERALD_ON_A_STICK_WITH_FW = new EmeraldOnAStickWithFW(new FabricItemSettings());
    public static final Item WHEAT_SEEDS_ON_A_STICK = new WheatSeedsOnAStick(new FabricItemSettings());
    public static final Item WHEAT_SEEDS_ON_A_STICK_WITH_FW = new WheatSeedsOnAStickWithFW(new FabricItemSettings());
    public static final Item WHEAT_ON_A_STICK = new WheatOnAStickWithFW(new FabricItemSettings());
    public static final Item WHEAT_ON_A_STICK_WITH_FW = new WheatOnAStickWithFW(new FabricItemSettings());
    public static final Item FLOWER_ON_A_STICK = new FlowerOnAStick(new FabricItemSettings());
    public static final Item FLOWER_ON_A_STICK_WITH_FW = new FlowerOnAStickWithFW(new FabricItemSettings());
    public static final Item INIT_WITH_FW = new InitWithFW(new FabricItemSettings());

    public static void register(){

        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"golden_carrot_on_a_stick"),GOLDEN_CARROT_ON_A_STICK);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"golden_carrot_on_a_stick_with_fw"),GOLDEN_CARROT_ON_A_STICK_WITH_FW);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"emerald_on_a_stick"),EMERALD_ON_A_STICK);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"emerald_on_a_stick_with_fw"),EMERALD_ON_A_STICK_WITH_FW);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"wheat_seeds_on_a_stick"),WHEAT_SEEDS_ON_A_STICK);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"wheat_seeds_on_a_stick_with_fw"),WHEAT_SEEDS_ON_A_STICK_WITH_FW);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"wheat_on_a_stick"),WHEAT_ON_A_STICK);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"wheat_on_a_stick_with_fw"),WHEAT_ON_A_STICK_WITH_FW);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"init_with_fw"),INIT_WITH_FW);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"flower_on_a_stick"),FLOWER_ON_A_STICK);
        Registry.register(Registries.ITEM, new Identifier(MoreRiders.ModID,"flower_on_a_stick_with_fw"),FLOWER_ON_A_STICK_WITH_FW);

    }
}
