package name.yassien.deepdarkupdate.util;

import name.yassien.deepdarkupdate.DeepDarkUpdate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags
{
    public static class Blocks
    {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DeepDarkUpdate.MOD_ID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> TAG_TEST = createTag("tag_test");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DeepDarkUpdate.MOD_ID, name));
        }
    }
}
