package name.modid.entity.custom.bic_crystal_entity;

import name.modid.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BicCrystalNoirEntity extends BicCrystalEntity {
    public BicCrystalNoirEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BicCrystalNoirEntity(LivingEntity livingEntity, World world) {
        super(livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BIC_CRYSTAL_NOIR;
    }
}
