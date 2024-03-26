package name.modid.entity.custom.bic_crystal_entity;

import name.modid.item.ModItems;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BicCrystalBleuEntity extends BicCrystalEntity {
    public BicCrystalBleuEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BicCrystalBleuEntity(LivingEntity livingEntity, World world) {
        super(livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BIC_CRYSTAL_BLEU;
    }
}
