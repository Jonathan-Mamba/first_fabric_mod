package name.modid.datagen.recipes;

import name.modid.datagen.ModRecipeProvider;
import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import java.util.HashMap;

public class QuatreCouleursRecipeProvider extends CustomRecipeProvider {
    public QuatreCouleursRecipeProvider(FabricDataOutput output, ModRecipeProvider provider) {
        super(output, provider);
    }
    public void generate(RecipeExporter exporter) {
        generateRecipe().offerTo(exporter);
    }
    private ShapedRecipeJsonBuilder generateRecipe() {
        HashMap<Character, ItemConvertible> map = new HashMap<>(2);
        map.put('#', ModItems.BIC_CRYSTAL_PACK);
        map.put('!', Items.IRON_NUGGET);
        return recipeProvider.generateSimpleShapedRecipe(RecipeCategory.MISC, ModItems.QUATRE_COULEURS_BASE, map, new String[]{"!#!"});
    }
}
