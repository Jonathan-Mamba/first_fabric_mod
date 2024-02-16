package name.modid.datagen;

import com.mojang.datafixers.types.templates.Tag;
import name.modid.block.ModBlocks;
import name.modid.item.ModItems;
import name.modid.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;


public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BIC_CRYSTAL, RecipeCategory.MISC,
                ModBlocks.STYLO_BLOCK);
    }

    private void generateStyloRecipe(Item stylo) {

    }
}
