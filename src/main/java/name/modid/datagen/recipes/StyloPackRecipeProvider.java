package name.modid.datagen.recipes;

import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;

public class StyloPackRecipeProvider extends CustomRecipeProvider {

    public StyloPackRecipeProvider(FabricDataOutput output) {
        super(output);
    }


    public void generate(RecipeExporter exporter) {
        getStyloPackRecipe().offerTo(exporter);
        getBicCrystalRecipe().offerTo(exporter, "bic_crystal_from_bic_crystal_pack");
    }
    private ShapelessRecipeJsonBuilder getStyloPackRecipe() {
        return generateSimpleShapelessRecipe(RecipeCategory.MISC, ModItems.BIC_CRYSTAL_PACK,
                new Item[]{ModItems.BIC_CRYSTAL_BLEU, ModItems.BIC_CRYSTAL_ROUGE, ModItems.BIC_CRYSTAL_VERT, ModItems.BIC_CRYSTAL_NOIR});
    }
    private ShapelessRecipeJsonBuilder getBicCrystalRecipe() {
        return generateSimpleShapelessRecipe(RecipeCategory.MISC, ModItems.BIC_CRYSTAL, new Item[]{ModItems.BIC_CRYSTAL_PACK}, 4);
    }
}
