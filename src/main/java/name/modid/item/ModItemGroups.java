package name.modid.item;

import name.modid.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import name.modid.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "mod_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod"))
                    .icon(() -> new ItemStack(ModItems.BIC_CTYSTAL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BIC_CTYSTAL);
                        entries.add(ModItems.STYLO_NWAR);
                        entries.add(ModBlocks.STYLO_BLOCK);
                        entries.add(ModItems.QUATRE_COULEURS_BASE);
                        entries.add(ModItems.STYLO_ROUGE);
                        entries.add(ModItems.STYLO_BLEU);
                        entries.add(ModItems.STYLO_NOIR);
                        entries.add(ModItems.STYLO_VERT);
                        entries.add(ModItems.BIC_CRYSTAL_PACK);
                    }).build());

    public static void registerItemsGroup() {
        TutorialMod.LOGGER.info("Registering item groups");
    }
}

