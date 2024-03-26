package name.modid.datagen.recipes;

import name.modid.datagen.ModRecipeProvider;
import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.HashMap;
import java.util.Map;

public class MiscRecipeProvider extends CustomRecipeProvider {

    public MiscRecipeProvider(FabricDataOutput output, ModRecipeProvider provider) {
        super(output, provider);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        getInkedArrowRecipe().offerTo(exporter);
    }

    private ShapedRecipeJsonBuilder getInkedArrowRecipe() {
        Map<Character, ItemConvertible> map = new HashMap<>();
        map.put('!', Items.ARROW);
        map.put('#', Items.INK_SAC);
        return recipeProvider.generateSimpleShapedRecipe(
                RecipeCategory.COMBAT,
                ModItems.INKED_ARROW,
                map,
                new String[]{"###",
                             "#!#",
                             "###"}
                );
    }
}
