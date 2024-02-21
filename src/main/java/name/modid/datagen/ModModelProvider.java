package name.modid.datagen;

import name.modid.block.ModBlocks;
import name.modid.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block[] cubeAllBlocks = {
                ModBlocks.STYLO_BLOCK
        };

        for (Block block : cubeAllBlocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Item[] items = {
                ModItems.BIC_CRYSTAL,
                ModItems.BIC_CRYSTAL_BLEU,
                ModItems.BIC_CRYSTAL_NOIR,
                ModItems.BIC_CRYSTAL_ROUGE,
                ModItems.BIC_CRYSTAL_VERT,
                ModItems.BIC_CRYSTAL_PACK,
                ModItems.QUATRE_COULEURS_BASE
        };
        for (Item item : items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
