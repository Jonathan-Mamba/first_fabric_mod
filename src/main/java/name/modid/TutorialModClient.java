package name.modid;

import name.modid.entity.ModEntities;
import name.modid.entity.custom.renderer.BicProjectileRenderer;
import name.modid.entity.custom.renderer.InkedArrowRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TEST_PROJECTILE, BicProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.INKED_ARROW, InkedArrowRenderer::new);
    }
}
