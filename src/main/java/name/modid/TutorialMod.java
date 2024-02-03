package name.modid;

import name.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		for (int i = 0; i < 20; i++) {
			LOGGER.info("Hello Fabric world!");
		}
		ModItems.registerModItems();

	}
}