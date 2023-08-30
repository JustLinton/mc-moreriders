package linton.moreriders.items;

import net.minecraft.item.Item;

public class WheatOnAStickWithFW extends FireworkStickBase {
    public WheatOnAStickWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return ModItems.WHEAT_ON_A_STICK;
    }
}
