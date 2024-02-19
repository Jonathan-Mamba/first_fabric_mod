package name.modid.datagen.recipes;

import name.modid.datagen.ModRecipeProvider;
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

public class StyloRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider recipeProvider;
    public StyloRecipeProvider(FabricDataOutput output, ModRecipeProvider provider) {
        super(output);
        recipeProvider = provider;
    }

    @Override
    public void generate(RecipeExporter exporter) {
        LOGGER.info("registering stylo recipes");

        generateStyloRecipeFromMaterials(ModItems.BIC_CRYSTAL).offerTo(exporter, "bic_crystal_from_materials");
        generateStyloRecipeFromOthers(ModItems.BIC_CRYSTAL).offerTo(exporter, "bic_crystal_from_others");

        Item[][] var = {
                {ModItems.BIC_CRYSTAL_BLEU, Items.BLUE_DYE},
                {ModItems.BIC_CRYSTAL_NOIR, Items.BLACK_DYE},
                {ModItems.BIC_CRYSTAL_ROUGE, Items.RED_DYE},
                {ModItems.BIC_CRYSTAL_VERT, Items.GREEN_DYE}
        };

        for (Item[] element : var) {
            generateStyloRecipeFromMaterials(element[0], element[1]).offerTo(exporter, element[0].toString() + "_from_materials");
            generateStyloRecipeFromOthers(element[0], element[1]).offerTo(exporter, element[0].toString() + "_from_others");
        }
    }

    private ShapelessRecipeJsonBuilder generateStyloRecipeFromOthers(Item stylo, Item dye) {
        return recipeProvider.generateSimpleCriterions(ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                        .input(ModTags.BICS_CRYSTAL)
                        .input(dye),
                new Item[]{stylo, dye});
    }

    private ShapelessRecipeJsonBuilder generateStyloRecipeFromOthers(Item stylo) {
        return recipeProvider.generateSimpleCriterions(ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                .input(ModTags.BICS_CRYSTAL), new Item[]{stylo});
    }

    private ShapedRecipeJsonBuilder generateStyloRecipeFromMaterials(Item stylo, Item dye) {
        Item mine = Items.GOLD_NUGGET;
        Item encre = Items.INK_SAC;
        Item tsaisLaCoqueTransparenteLa = Items.GLASS_PANE;

        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                .pattern("#*#")
                .pattern("#!#")
                .pattern("#v#")
                .input('!', encre)
                .input('#', tsaisLaCoqueTransparenteLa)
                .input('*', dye)
                .input('v', mine);

        return recipeProvider.generateSimpleCriterions(recipe, new Item[]{mine, encre, tsaisLaCoqueTransparenteLa, dye});
    }

    private ShapedRecipeJsonBuilder generateStyloRecipeFromMaterials(Item stylo) {
        Item mine = Items.GOLD_NUGGET;
        Item encre = Items.INK_SAC;
        Item tsaisLaCoqueTransparenteLa = Items.GLASS_PANE;

        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BIC_CRYSTAL)
                .pattern("# #")
                .pattern("#!#")
                .pattern("#v#")
                .input('!', encre)
                .input('#', tsaisLaCoqueTransparenteLa)
                .input('v', mine);

        return recipeProvider.generateSimpleCriterions(recipe, new Item[]{mine, encre, tsaisLaCoqueTransparenteLa});
    }
}
