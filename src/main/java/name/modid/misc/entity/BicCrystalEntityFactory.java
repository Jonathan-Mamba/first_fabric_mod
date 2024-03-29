package name.modid.misc.entity;

import name.modid.entity.ModEntities;
import name.modid.entity.custom.bic_crystal_entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BicCrystalEntityFactory {
    public static BicCrystalEntity getEntity(PlayerEntity user, World world, String classKey) {
        return switch (classKey) {
            case "blue" -> {
                yield new BicCrystalBleuEntity(user, world);
            }
            case "black" -> {
                yield new BicCrystalNoirEntity(user, world);
            }
            case "red" -> {
                yield new BicCrystalRougeEntity(user, world);
            }
            case "green" -> {
                yield new BicCrystalVertEntity(user, world);
            }
            case "blank" -> new BicCrystalEntity(user, world);
            case null, default -> new BicCrystalEntity(user, world);
        };
    }
    public static BicCrystalEntity getEntity(double d, double e, double f, World world, String classKey) {
        return switch (classKey) {
            case "blue" -> {
                yield new BicCrystalBleuEntity(ModEntities.BIC_CRYSTAL_BLEU_ENTITY, d, e, f, world);
            }
            case "black" -> {
                yield new BicCrystalNoirEntity(ModEntities.BIC_CRYSTAL_NOIR_ENTITY, d, e, f, world);
            }
            case "red" -> {
                yield new BicCrystalRougeEntity(ModEntities.BIC_CRYSTAL_ROUGE_ENTITY, d, e, f, world);
            }
            case "green" -> {
                yield new BicCrystalVertEntity(ModEntities.BIC_CRYSTAL_VERT_ENTITY, d, e, f, world);
            }
            case "blank" -> new BicCrystalEntity(ModEntities.BIC_CRYSTAL_ENTITY, d, e, f, world);
            case null, default -> new BicCrystalEntity(ModEntities.BIC_CRYSTAL_ENTITY, d, e, f, world);
        };
    }
}
