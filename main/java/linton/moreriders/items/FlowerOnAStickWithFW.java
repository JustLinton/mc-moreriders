package linton.moreriders.items;

import net.minecraft.item.Item;

public class FlowerOnAStickWithFW extends FireworkStickBase {
    public FlowerOnAStickWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return ModItems.FLOWER_ON_A_STICK;
    }
}
