package name.modid.datagen.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.Map;

public class CustomRecipeProvider extends FabricRecipeProvider {

    public CustomRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) { }

    public ShapedRecipeJsonBuilder generateSimpleCriterions(ShapedRecipeJsonBuilder builder, ItemConvertible[] items) {
        for (ItemConvertible item : items) {
            builder.criterion(FabricRecipeProvider.hasItem(item), FabricRecipeProvider.conditionsFromItem(item));}
        return builder;
    }
    public ShapelessRecipeJsonBuilder generateSimpleCriterions(ShapelessRecipeJsonBuilder builder, ItemConvertible[] items) {
        for (ItemConvertible item : items) {
            builder.criterion(FabricRecipeProvider.hasItem(item), FabricRecipeProvider.conditionsFromItem(item));}
        return builder;
    }


    public ShapelessRecipeJsonBuilder generateSimpleShapelessRecipe(RecipeCategory category, ItemConvertible output, Item[] items) {
        ShapelessRecipeJsonBuilder recipe = ShapelessRecipeJsonBuilder.create(category, output);
        for (ItemConvertible item : items) {
            recipe.input(item);
        }
        return generateSimpleCriterions(recipe, items);
    }
    public ShapelessRecipeJsonBuilder generateSimpleShapelessRecipe(RecipeCategory category, ItemConvertible output, Item[] items, int outputCount) {
        ShapelessRecipeJsonBuilder recipe = ShapelessRecipeJsonBuilder.create(category, output, outputCount);
        for (ItemConvertible item : items) {
            recipe.input(item);
        }
        return generateSimpleCriterions(recipe, items);
    }


    public ShapedRecipeJsonBuilder generateSimpleShapedRecipe(RecipeCategory category, ItemConvertible output, Map<Character, ItemConvertible> items, String[] pattern) {
        ShapedRecipeJsonBuilder recipe = new ShapedRecipeJsonBuilder(category, output, 1);
        for (String line : pattern) { recipe.pattern(line); }
        for (Character key : items.keySet()) { recipe.input(key, items.get(key)); }
        return generateSimpleCriterions(recipe, items.values().toArray(new ItemConvertible[0])); // me demande pas pk pcq je sais pas
    }
    public ShapedRecipeJsonBuilder generateSimpleShapedRecipe(RecipeCategory category, ItemConvertible output, Map<Character, ItemConvertible> items, String[] pattern, int outputCount) {
        ShapedRecipeJsonBuilder recipe = new ShapedRecipeJsonBuilder(category, output, outputCount);
        for (String line : pattern) { recipe.pattern(line); }
        for (Character key : items.keySet()) { recipe.input(key, items.get(key)); }
        return generateSimpleCriterions(recipe, items.values().toArray(new ItemConvertible[0]));
    }
}
