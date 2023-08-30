package linton.moreriders.items;

import net.minecraft.item.Item;

public class SeagrassOnAStickWithFW extends FireworkStickBase {
    public SeagrassOnAStickWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return ModItems.SEAGRASS_ON_A_STICK;
    }
}
