package name.modid.entity;

import name.modid.TutorialMod;
import name.modid.entity.custom.BicCrystalProjectileEntity;
import name.modid.entity.custom.InkedArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BicCrystalProjectileEntity> TEST_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "test_projectile"),
            FabricEntityTypeBuilder.<BicCrystalProjectileEntity>create(SpawnGroup.MISC, BicCrystalProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(.25f, .25f)).build());

    public static final EntityType<InkedArrowEntity> INKED_ARROW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "inked_arrow"),
            FabricEntityTypeBuilder.<InkedArrowEntity>create(SpawnGroup.MISC, InkedArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(.25f, .25f)).build());
}
