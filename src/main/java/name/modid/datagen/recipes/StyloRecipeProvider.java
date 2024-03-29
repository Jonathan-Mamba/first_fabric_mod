package name.modid.datagen.recipes;

import name.modid.item.ModItems;
import name.modid.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class StyloRecipeProvider extends CustomRecipeProvider {
    //public ModRecipeProvider recipeProvider;
    public StyloRecipeProvider(FabricDataOutput output) {
        super(output);
        //recipeProvider = provider;
    }

    public void generate(RecipeExporter exporter) {
        LOGGER.info("registering stylo recipes");

        generateBicsCrystalRecipes(exporter);
    }

    private void generateBicsCrystalRecipes(RecipeExporter exporter){
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
        return generateSimpleCriterions(ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                        .input(ModTags.BICS_CRYSTAL)
                        .input(dye),
                new Item[]{stylo, dye});
    }

    private ShapelessRecipeJsonBuilder generateStyloRecipeFromOthers(Item stylo) {
        return generateSimpleCriterions(ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                .input(ModTags.BICS_CRYSTAL), new Item[]{stylo});
    }

    private ShapedRecipeJsonBuilder generateStyloRecipeFromMaterials(Item stylo, Item dye) {
        Item mine = Items.GOLD_NUGGET;
        Item ink = Items.INK_SAC;
        Item tsaisLaCoqueTransparenteLa = Items.GLASS_PANE;

        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                .pattern("#*#")
                .pattern("#!#")
                .pattern("#v#")
                .input('!', ink)
                .input('#', tsaisLaCoqueTransparenteLa)
                .input('*', dye)
                .input('v', mine);

        return generateSimpleCriterions(recipe, new Item[]{mine, ink, tsaisLaCoqueTransparenteLa, dye});
    }

    private ShapedRecipeJsonBuilder generateStyloRecipeFromMaterials(Item stylo) {
        Item mine = Items.GOLD_NUGGET;
        Item ink = Items.INK_SAC;
        Item tsaisLaCoqueTransparenteLa = Items.GLASS_PANE;

        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, stylo)
                .pattern("# #")
                .pattern("#!#")
                .pattern("#v#")
                .input('!', ink)
                .input('#', tsaisLaCoqueTransparenteLa)
                .input('v', mine);

        return generateSimpleCriterions(recipe, new Item[]{mine, ink, tsaisLaCoqueTransparenteLa});
    }
}
