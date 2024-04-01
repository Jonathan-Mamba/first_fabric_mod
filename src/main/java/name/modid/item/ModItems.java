package name.modid.item;

import name.modid.TutorialMod;
import name.modid.item.custom.BicCrystalItem;
import name.modid.item.custom.InkedArrowItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static final FabricItemSettings settings = new FabricItemSettings();
    public static final Item QUATRE_COULEURS_BASE = registerItem("quatre_couleurs_base");
    public static final Item BIC_CRYSTAL = registerItem("bic_crystal", new BicCrystalItem());
    public static final Item BIC_CRYSTAL_ROUGE = registerItem("bic_crystal_rouge", new BicCrystalItem());
    public static final Item BIC_CRYSTAL_VERT = registerItem("bic_crystal_vert", new BicCrystalItem());
    public static final Item BIC_CRYSTAL_NOIR = registerItem("bic_crystal_noir", new BicCrystalItem());
    public static final Item BIC_CRYSTAL_BLEU = registerItem("bic_crystal_bleu", new BicCrystalItem());
    public static final Item BIC_CRYSTAL_PACK = registerItem("bic_crystal_pack");
    public static final Item INKED_ARROW = registerItem("inked_arrow", new InkedArrowItem(settings));




    public static Item registerItem(String name) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), new Item(settings));
    }
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering items for " + TutorialMod.MOD_ID);
    }
}
