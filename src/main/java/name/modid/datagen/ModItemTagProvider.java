package name.modid.datagen;

import name.modid.item.ModItems;
import name.modid.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.BICS_CRYSTAL)
                .add(ModItems.BIC_CRYSTAL_BLEU)
                .add(ModItems.BIC_CRYSTAL)
                .add(ModItems.BIC_CRYSTAL_NOIR)
                .add(ModItems.BIC_CRYSTAL_ROUGE)
                .add(ModItems.BIC_CRYSTAL_VERT);

        getOrCreateTagBuilder(ItemTags.ARROWS).add(ModItems.INKED_ARROW);

    }
}
