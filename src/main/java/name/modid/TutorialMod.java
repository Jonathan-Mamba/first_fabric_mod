package name.modid;

import name.modid.block.ModBlocks;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import name.modid.util.ModDispenserBehaviours;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemsGroup();
		ModDispenserBehaviours.registerDispenserBehaviors();
		LOGGER.debug(ModItems.INKED_ARROW.getTranslationKey());
		LOGGER.info(ModItems.INKED_ARROW.getTranslationKey());
		LOGGER.info(ModItems.INKED_ARROW.toString());
	}

}