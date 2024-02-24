package name.modid.item.custom;

import name.modid.entity.custom.InkedArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InkedArrowItem extends ArrowItem {
    public InkedArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        InkedArrowEntity arrowEntity = new InkedArrowEntity(world, shooter, stack.copyWithCount(1));
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
