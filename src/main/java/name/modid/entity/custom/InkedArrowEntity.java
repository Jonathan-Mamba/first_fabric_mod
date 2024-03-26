package name.modid.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.world.World;

public class InkedArrowEntity extends ArrowEntity {
    private final double DAMAGE =  2.0;
    private final int EFFECT_DURATION = 200;
    public InkedArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.addEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, EFFECT_DURATION));
        this.setDamage(DAMAGE);
    }

    public InkedArrowEntity(World world, LivingEntity shooter, ItemStack itemStack) {
        super(world, shooter, itemStack);
        this.addEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100));
        this.setDamage(DAMAGE);
    }

}
