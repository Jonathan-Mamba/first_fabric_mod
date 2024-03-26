package name.modid;

import com.google.common.collect.Maps;
import name.modid.block.ModBlocks;
import name.modid.entity.custom.bic_crystal_entity.BicCrystalEntity;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;
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
		Maps.EntryTransformer<EntityType<? extends ThrownItemEntity>, World, BicCrystalEntity> entity = BicCrystalEntity::new;
	}

}