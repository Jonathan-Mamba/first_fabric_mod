package name.modid.item;

import name.modid.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STYLO_NWAR = registerItem("stylo");
    public static final Item BIC_CTYSTAL = registerItem("bic_crystal");
    public static final Item QUATRE_COULEURS_BASE = registerItem("quatre_couleurs_base");
    public static final Item STYLO_ROUGE = registerItem("stylo_rouge");

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(STYLO_NWAR);
        entries.add(BIC_CTYSTAL);
        entries.add(QUATRE_COULEURS_BASE);
    }


    public static Item registerItem(String name) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), new Item(new FabricItemSettings()));
    }
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering items for " + TutorialMod.MOD_ID);

        // ItemGroupEvents.modifyEntriesEvent(ItemGroups.M).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
