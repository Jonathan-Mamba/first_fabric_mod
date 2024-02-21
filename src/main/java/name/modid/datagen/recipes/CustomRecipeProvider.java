package name.modid.datagen.recipes;

import name.modid.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;

public class CustomRecipeProvider extends FabricRecipeProvider {
    protected ModRecipeProvider recipeProvider;
    public CustomRecipeProvider(FabricDataOutput output, ModRecipeProvider provider) {
        super(output);
        recipeProvider = provider;
    }

    @Override
    public void generate(RecipeExporter exporter) { }
}
