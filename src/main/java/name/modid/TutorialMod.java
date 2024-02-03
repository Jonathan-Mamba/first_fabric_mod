package name.modid;

import name.modid.block.ModBlocks;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItemGroups.registerItemsGroup();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}