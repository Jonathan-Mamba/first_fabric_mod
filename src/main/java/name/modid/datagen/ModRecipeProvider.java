package name.modid.datagen;

import name.modid.block.ModBlocks;
import name.modid.datagen.recipes.StyloRecipeProvider;
import name.modid.item.ModItems;
import name.modid.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;



public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BIC_CRYSTAL, RecipeCategory.MISC,
                ModBlocks.STYLO_BLOCK);

        new StyloRecipeProvider(output, this).generate(exporter);
    }

    public ShapedRecipeJsonBuilder generateSimpleCriterions(ShapedRecipeJsonBuilder builder, Item[] items) {
        for (Item item : items) {
            builder.criterion(FabricRecipeProvider.hasItem(item), FabricRecipeProvider.conditionsFromItem(item));}
        return builder;
    }

    public ShapelessRecipeJsonBuilder generateSimpleCriterions(ShapelessRecipeJsonBuilder builder, Item[] items) {
        for (Item item : items) {
            builder.criterion(FabricRecipeProvider.hasItem(item), FabricRecipeProvider.conditionsFromItem(item));}
        return builder;
    }
}
