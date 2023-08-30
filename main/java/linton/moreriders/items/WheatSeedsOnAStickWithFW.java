package linton.moreriders.items;

import net.minecraft.item.Item;

public class WheatSeedsOnAStickWithFW extends FireworkStickBase {
    public WheatSeedsOnAStickWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return ModItems.WHEAT_SEEDS_ON_A_STICK;
    }
}
