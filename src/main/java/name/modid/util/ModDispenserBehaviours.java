package name.modid.util;

import name.modid.entity.custom.InkedArrowEntity;
import name.modid.item.ModItems;
import name.modid.item.custom.BicCrystalItem;
import name.modid.misc.entity.BicCrystalEntityFactory;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class ModDispenserBehaviours {
    public static void registerDispenserBehaviors() {
        registerBicCrystalBehavior((BicCrystalItem) ModItems.BIC_CRYSTAL);
        registerBicCrystalBehavior((BicCrystalItem) ModItems.BIC_CRYSTAL_VERT);
        registerBicCrystalBehavior((BicCrystalItem) ModItems.BIC_CRYSTAL_NOIR);
        registerBicCrystalBehavior((BicCrystalItem) ModItems.BIC_CRYSTAL_BLEU);
        registerBicCrystalBehavior((BicCrystalItem) ModItems.BIC_CRYSTAL_ROUGE);
        registerInkedArrowBehavior();
    }

    private static void registerBicCrystalBehavior(BicCrystalItem item) {
        DispenserBlock.registerBehavior(item, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(BicCrystalEntityFactory.getEntity(position.getX(), position.getY(), position.getZ(), world, item.toString()), entity -> entity.setItem(stack));
            }
        });
    }
    private static void registerInkedArrowBehavior() {
        DispenserBlock.registerBehavior(ModItems.INKED_ARROW, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                InkedArrowEntity arrowEntity = new InkedArrowEntity(world, position.getX(), position.getY(), position.getZ(), stack.copyWithCount(1));
                arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                return arrowEntity;
            }
        });
    }
}
