package name.modid.item.custom;

import name.modid.entity.custom.StyloArrowProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StyloArrowItem extends ArrowItem {
    public StyloArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        StyloArrowProjectileEntity arrowEntity = new StyloArrowProjectileEntity(world, shooter, stack.copyWithCount(1));
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
