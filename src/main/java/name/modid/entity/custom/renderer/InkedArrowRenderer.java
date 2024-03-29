package name.modid.entity.custom.renderer;

import name.modid.TutorialMod;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class InkedArrowRenderer extends ArrowEntityRenderer {
    public InkedArrowRenderer(EntityRendererFactory.Context context) { super(context); }
    @Override
    public Identifier getTexture(ArrowEntity arrowEntity) {
        return new Identifier(TutorialMod.MOD_ID,"textures/entity/projectiles/inked_arrow.png");
    }
}
