
package com.epikwem.preciousores.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;

import static com.epikwem.preciousores.Main.setup;

public enum ModIngots {

    SILVER_INGOT("silver");

    private final String oreName;
    private final Item item;

    private ModIngots(String _oreName) {
        oreName = _oreName;
        item = new Item( new Item.Properties().group(ItemGroup.MATERIALS) );
    }

    public void registerOreItems(final RegistryEvent.Register<Item> _itemRegistryEvent) {
        _itemRegistryEvent.getRegistry().registerAll(
                setup(oreName+"_ingot", item),
                setup(oreName+"_nugget", new Item(new Item.Properties().group(ItemGroup.MATERIALS)))
        );
    }

    public String getOreName() {
        return oreName;
    }

    public Item getItem() {
        return item;
    }

}
