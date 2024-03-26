package name.modid.entity;

import name.modid.TutorialMod;
import name.modid.entity.custom.bic_crystal_entity.*;
import name.modid.entity.custom.InkedArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BicCrystalEntity> BIC_CRYSTAL_ENTITY = registerEntity(
            BicCrystalEntity::new, "bic_crystal_entity");

    public static final EntityType<BicCrystalBleuEntity> BIC_CRYSTAL_BLEU_ENTITY = registerEntity(
            BicCrystalBleuEntity::new, "bic_crystal_bleu_entity");

    public static final EntityType<BicCrystalNoirEntity> BIC_CRYSTAL_NOIR_ENTITY = registerEntity(
            BicCrystalNoirEntity::new, "bic_crystal_noir_entity");

    public static final EntityType<BicCrystalRougeEntity> BIC_CRYSTAL_ROUGE_ENTITY = registerEntity(
            BicCrystalRougeEntity::new, "bic_crystal_rouge_entity");

    public static final EntityType<BicCrystalVertEntity> BIC_CRYSTAL_VERT_ENTITY = registerEntity(
            BicCrystalVertEntity::new, "bic_crystal_vert_entity");

    public static final EntityType<InkedArrowEntity> INKED_ARROW = registerEntity(
            InkedArrowEntity::new, "inked_arrow");

    private static <T extends Entity> EntityType<T> registerEntity(EntityType.EntityFactory<T> constructor, String path) {
        return Registry.register(Registries.ENTITY_TYPE,
                new Identifier(TutorialMod.MOD_ID, path),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, constructor)
                        .dimensions(EntityDimensions.fixed(.25f, .25f)).build());
    }
}
