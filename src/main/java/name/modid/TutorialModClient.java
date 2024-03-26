package name.modid;

import name.modid.entity.ModEntities;
import name.modid.entity.custom.bic_crystal_entity.BicCrystalBleuEntity;
import name.modid.entity.custom.bic_crystal_entity.BicCrystalEntity;
import name.modid.entity.custom.renderer.BicProjectileRenderer;
import name.modid.entity.custom.renderer.InkedArrowRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        truc();
        EntityRendererRegistry.register(ModEntities.INKED_ARROW, InkedArrowRenderer::new);
    }
    private static void truc() {
        EntityRendererRegistry.register(ModEntities.BIC_CRYSTAL_ENTITY, BicProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.BIC_CRYSTAL_BLEU_ENTITY, BicProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.BIC_CRYSTAL_NOIR_ENTITY, BicProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.BIC_CRYSTAL_VERT_ENTITY, BicProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.BIC_CRYSTAL_ROUGE_ENTITY, BicProjectileRenderer::new);

    }
}
