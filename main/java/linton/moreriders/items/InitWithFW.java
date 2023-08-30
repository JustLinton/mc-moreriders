package linton.moreriders.items;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class InitWithFW extends FireworkStickBase {
    public InitWithFW(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDamageReplaceItem() {
        return Items.CARROT_ON_A_STICK;
    }
}
