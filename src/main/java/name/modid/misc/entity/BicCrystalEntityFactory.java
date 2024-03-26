package name.modid.misc.entity;

import name.modid.TutorialMod;
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
}
