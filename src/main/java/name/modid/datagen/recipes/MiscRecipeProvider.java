package name.modid.datagen.recipes;

import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.HashMap;

public class MiscRecipeProvider extends CustomRecipeProvider {

    public MiscRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        getInkedArrowRecipe().offerTo(exporter);
    }

    private ShapedRecipeJsonBuilder getInkedArrowRecipe() {
        return generateSimpleShapedRecipe(
                RecipeCategory.COMBAT,
                ModItems.INKED_ARROW,
                new HashMap<>() {{
                    put('!', Items.ARROW);
                    put('#', Items.INK_SAC);
                }},
                new String[]{"###",
                             "#!#",
                             "###"}
                );
    }
}
