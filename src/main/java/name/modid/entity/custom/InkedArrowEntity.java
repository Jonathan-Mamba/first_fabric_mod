package name.modid.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InkedArrowEntity extends ArrowEntity {
    protected final double DAMAGE =  2.0;// ca fait un coeur
    protected final int EFFECT_DURATION = 200; // je pense que c'est en millisecondes (200 -> 10s)
    protected final StatusEffectInstance EFFECT = new StatusEffectInstance(StatusEffects.BLINDNESS, EFFECT_DURATION);
    public InkedArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.setDamage(DAMAGE);
    }

    public InkedArrowEntity(World world, LivingEntity shooter, ItemStack itemStack) {
        super(world, shooter, itemStack);
        this.setDamage(DAMAGE);
    }

    public InkedArrowEntity(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
    }

    @Override
    protected void onHit(LivingEntity target) {
        target.addStatusEffect(EFFECT, this.getEffectCause());
    }
}
