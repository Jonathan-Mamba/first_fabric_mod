package name.modid.entity.custom.renderer;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class InkedArrowRenderer extends ArrowEntityRenderer {
    public InkedArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    @Override
    public Identifier getTexture(ArrowEntity arrowEntity) {
        return new Identifier("textures/entity/projectiles/arrow.png");
    }
}
