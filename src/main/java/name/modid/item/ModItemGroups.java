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
                    .icon(() -> new ItemStack(ModItems.BIC_CRYSTAL_PACK)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BIC_CRYSTAL);
                        entries.add(ModBlocks.STYLO_BLOCK);
                        entries.add(ModItems.QUATRE_COULEURS_BASE);
                        entries.add(ModItems.BIC_CRYSTAL_ROUGE);
                        entries.add(ModItems.BIC_CRYSTAL_BLEU);
                        entries.add(ModItems.BIC_CRYSTAL_NOIR);
                        entries.add(ModItems.BIC_CRYSTAL_VERT);
                        entries.add(ModItems.BIC_CRYSTAL_PACK);
                        entries.add(ModItems.INKED_ARROW);
                    }).build());

    public static void registerItemsGroup() { TutorialMod.LOGGER.info("Registering item groups"); }
}

