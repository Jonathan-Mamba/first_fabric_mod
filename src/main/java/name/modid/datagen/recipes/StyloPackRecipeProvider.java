package name.modid.datagen.recipes;

import name.modid.datagen.ModRecipeProvider;
import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;

public class StyloPackRecipeProvider extends CustomRecipeProvider {

    public StyloPackRecipeProvider(FabricDataOutput output, ModRecipeProvider provider) {
        super(output, provider);
    }


    public void generate(RecipeExporter exporter) {
        generateStyloPackRecipe().offerTo(exporter);
        generateBicCrystalRecipe().offerTo(exporter, "bic_crystal_from_bic_crystal_pack");
    }
    private ShapelessRecipeJsonBuilder generateStyloPackRecipe() {
        return recipeProvider.generateSimpleShapelessRecipe(RecipeCategory.MISC, ModItems.BIC_CRYSTAL_PACK,
                new Item[]{ModItems.BIC_CRYSTAL_BLEU, ModItems.BIC_CRYSTAL_ROUGE, ModItems.BIC_CRYSTAL_VERT, ModItems.BIC_CRYSTAL_NOIR});
    }
    private ShapelessRecipeJsonBuilder generateBicCrystalRecipe() {
        return recipeProvider.generateSimpleShapelessRecipe(RecipeCategory.MISC, ModItems.BIC_CRYSTAL, new Item[]{ModItems.BIC_CRYSTAL_PACK}, 4);
    }
}
