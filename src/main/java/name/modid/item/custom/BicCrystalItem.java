package name.modid.item.custom;

import name.modid.entity.custom.bic_crystal_entity.BicCrystalEntity;
import name.modid.misc.entity.BicCrystalEntityFactory;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BicCrystalItem extends Item {

    public BicCrystalItem(Settings settings) {
        super(settings);
    }
    public BicCrystalItem() { super(new FabricItemSettings());}

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            BicCrystalEntity bicCrystalEntity = BicCrystalEntityFactory.getEntity(user, world, this.toString());
            bicCrystalEntity.setItem(itemStack);
            bicCrystalEntity.setVelocity(user, user.getPitch(), user.getYaw(), 10.0f, 1.5f, 1.0f);
            world.spawnEntity(bicCrystalEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
