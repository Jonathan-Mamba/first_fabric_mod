package name.modid.util;

import name.modid.entity.custom.InkedArrowEntity;
import name.modid.entity.custom.bic_crystal_entity.BicCrystalEntity;
import name.modid.item.ModItems;
import name.modid.item.custom.BicCrystalProjectileItem;
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
    public void registerDispenserBehaviors() {
        registerBicCrystalBehavior((BicCrystalProjectileItem) ModItems.BIC_CRYSTAL);
        registerBicCrystalBehavior((BicCrystalProjectileItem) ModItems.BIC_CRYSTAL_VERT);
        registerBicCrystalBehavior((BicCrystalProjectileItem) ModItems.BIC_CRYSTAL_NOIR);
        registerBicCrystalBehavior((BicCrystalProjectileItem) ModItems.BIC_CRYSTAL_BLEU);
        registerBicCrystalBehavior((BicCrystalProjectileItem) ModItems.BIC_CRYSTAL_ROUGE);

    }

    public static void registerBicCrystalBehavior(BicCrystalProjectileItem item) {
        DispenserBlock.registerBehavior(item, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(BicCrystalEntityFactory.getEntity(position.getX(), position.getY(), position.getZ(), world, item.getTypeKey()), entity -> entity.setItem(stack));
            }
        });
    }
    public static void registerInkedArrowBehavior() {
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
