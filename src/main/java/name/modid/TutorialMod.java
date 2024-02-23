package name.modid;

import com.mojang.datafixers.types.templates.Tag;
import name.modid.block.ModBlocks;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import name.modid.util.ModTags;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BowItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagManagerLoader;
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
	}
	public static void info(String string) {LOGGER.info(string);}
}