package name.modid.datagen;

import name.modid.block.ModBlocks;
import name.modid.datagen.recipes.MiscRecipeProvider;
import name.modid.datagen.recipes.QuatreCouleursRecipeProvider;
import name.modid.datagen.recipes.StyloPackRecipeProvider;
import name.modid.datagen.recipes.StyloRecipeProvider;
import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.book.RecipeCategory;

// C'est vrmt chaint les overloads
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BIC_CRYSTAL, RecipeCategory.MISC,
                ModBlocks.STYLO_BLOCK);

        new StyloRecipeProvider(output).generate(exporter);
        new StyloPackRecipeProvider(output).generate(exporter);
        new QuatreCouleursRecipeProvider(output).generate(exporter);
        new MiscRecipeProvider(output).generate(exporter);
    }
}
