package name.yassien.deepdarkupdate.item;

import name.yassien.deepdarkupdate.DeepDarkUpdate;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(DeepDarkUpdate.MOD_ID, name),item);
    }






    public static void registerModItems() // this is "outside the class"
    {
        DeepDarkUpdate.LOGGER.info("registering mod items for " + DeepDarkUpdate.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
        });
    }
}
