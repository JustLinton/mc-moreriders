package linton.moreriders.items;

import net.minecraft.item.Item;

public class GoldenCarrotOnAStickWithFW extends FireworkStickBase{
    public GoldenCarrotOnAStickWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return ModItems.GOLDEN_CARROT_ON_A_STICK;
    }
}
