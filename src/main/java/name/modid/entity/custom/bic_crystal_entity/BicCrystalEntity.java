package name.modid.entity.custom.bic_crystal_entity;

import name.modid.entity.ModEntities;
import name.modid.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;


public class BicCrystalEntity extends ThrownItemEntity {
    private final float DAMAGE = 4.0f;
    public BicCrystalEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BicCrystalEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.BIC_CRYSTAL_ENTITY, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BIC_CRYSTAL;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    protected void playGlassSound() {
        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.BLOCK_GLASS_BREAK, 1.0f));
    }
    protected void playGlassSound(float pitch) {
        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.BLOCK_GLASS_BREAK, pitch));
    }
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
            playGlassSound();
            this.kill();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        super.onEntityHit(entityHitResult);
        playGlassSound();
        // si c'est un truc vivant et pas un enderman
        if (entity instanceof LivingEntity && entity.getType() != EntityType.ENDERMAN) {
            DamageSources damageSources = new DamageSources(MinecraftClient.getInstance().world.getRegistryManager());
            entity.damage(damageSources.genericKill(), DAMAGE);
        }
    }
}
