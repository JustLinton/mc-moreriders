package linton.moreriders;

import linton.moreriders.handlers.CommandHandler;
import linton.moreriders.handlers.KeyInputHandler;
import linton.moreriders.handlers.RiderHandler;
import linton.moreriders.items.*;
import net.fabricmc.api.ModInitializer;

public class MoreRiders implements ModInitializer {

    public static final String ModID = "moreriders";

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        ModItems.register();
        ModItemGroup.register();
        RiderHandler.register();
        KeyInputHandler.register();
        CommandHandler.register();
    }


}
