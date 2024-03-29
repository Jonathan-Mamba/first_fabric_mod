package name.modid.datagen.recipes;


import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;

import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import java.util.HashMap;

public class QuatreCouleursRecipeProvider extends CustomRecipeProvider {
    public QuatreCouleursRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    public void generate(RecipeExporter exporter) {
        getRecipe().offerTo(exporter);
    }
    private ShapedRecipeJsonBuilder getRecipe() {
        return generateSimpleShapedRecipe(
                RecipeCategory.MISC,
                ModItems.QUATRE_COULEURS_BASE,
                new HashMap<>(){{
                    put('#', ModItems.BIC_CRYSTAL_PACK);
                    put('!', Items.IRON_NUGGET);
                }},
                new String[]{"!#!"});
    }
}
