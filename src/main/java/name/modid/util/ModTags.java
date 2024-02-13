package name.modid.util;

import name.modid.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Item> BICS_CRYSTAL = Items.createTag("bics_crystal");
    public static class Blocks {

    }
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TutorialMod.MOD_ID, name));
        }
    }
}
