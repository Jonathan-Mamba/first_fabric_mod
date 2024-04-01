package name.modid.misc.entity;

import name.modid.item.ModItems;
import name.modid.entity.ModEntities;
import name.modid.entity.custom.bic_crystal_entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BicCrystalEntityFactory {
    public static BicCrystalEntity getEntity(PlayerEntity user, World world, String classKey) {
        return switch (classKey) {
            case "bic_crystal_bleu" -> new BicCrystalBleuEntity(user, world);
            case "bic_crystal_noir" -> new BicCrystalNoirEntity(user, world);
            case "bic_crystal_rouge" -> new BicCrystalRougeEntity(user, world);
            case "bic_crystal_vert" -> new BicCrystalVertEntity(user, world);
            case null, default -> new BicCrystalEntity(user, world);
        };
    }
    public static BicCrystalEntity getEntity(double d, double e, double f, World world, String classKey) {
        return switch (classKey) {
            case "bic_crystal_bleu" -> {
                yield new BicCrystalBleuEntity(ModEntities.BIC_CRYSTAL_BLEU_ENTITY, d, e, f, world);
            }
            case "bic_crystal_noir" -> {
                yield new BicCrystalNoirEntity(ModEntities.BIC_CRYSTAL_NOIR_ENTITY, d, e, f, world);
            }
            case "bic_crystal_rouge" -> {
                yield new BicCrystalRougeEntity(ModEntities.BIC_CRYSTAL_ROUGE_ENTITY, d, e, f, world);
            }
            case "bic_crystal_vert" -> {
                yield new BicCrystalVertEntity(ModEntities.BIC_CRYSTAL_VERT_ENTITY, d, e, f, world);
            }
            case null, default -> new BicCrystalEntity(ModEntities.BIC_CRYSTAL_ENTITY, d, e, f, world);
        };
    }
}
