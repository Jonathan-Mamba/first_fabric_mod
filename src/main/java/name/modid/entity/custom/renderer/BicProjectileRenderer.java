package name.modid.entity.custom.renderer;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.util.math.RotationAxis;

public class BicProjectileRenderer<T extends Entity & FlyingItemEntity> extends FlyingItemEntityRenderer<T> {
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean lit;

    public BicProjectileRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
        super(ctx, scale, lit);
        this.itemRenderer = ctx.getItemRenderer();
        this.scale = scale;
        this.lit = lit;
    }

    public BicProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.scale = 1.0f;
        this.lit = false;

    }

    @Override
    public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age < 2 && this.dispatcher.camera.getFocusedEntity().squaredDistanceTo(entity) < 12.25) {
            return;
        }
        matrices.push();
        matrices.scale(this.scale, this.scale, this.scale);
        matrices.multiply(this.dispatcher.getRotation());
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));
        this.itemRenderer.renderItem(entity.getStack(), ModelTransformationMode.GROUND, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), entity.getId());
        matrices.pop();
        renderSuperSuper(entity, yaw, tickDelta, matrices, vertexConsumers, light);

    }
    public void renderSuperSuper(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        // fait la même chose que render dans EntityRenderer
        if (!this.hasLabel(entity)) {
            return;
        }
        this.renderLabelIfPresent(entity, entity.getDisplayName(), matrices, vertexConsumers, light);
    }
}
