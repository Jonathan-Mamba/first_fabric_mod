package name.modid.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StyloArrowProjectileEntity extends ArrowEntity {
    public StyloArrowProjectileEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.addEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 2000));
        this.setDamage(4.0);
    }

    public StyloArrowProjectileEntity(World world, LivingEntity shooter, ItemStack itemStack) {
        super(world, shooter, itemStack);
    }
}
