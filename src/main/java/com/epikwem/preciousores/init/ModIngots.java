
package com.epikwem.preciousores.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;

public enum ModIngots {

    SILVER_INGOT("silver");

    private final String oreName;
    private final Item item;

    private ModIngots(String _oreName) {
        oreName = _oreName;
        item = new Item( new Item.Properties().group(ItemGroup.MATERIALS) );
    }

    public void registerAllFeatures(final RegistryEvent.Register<Block> _blockRegistryEvent, final RegistryEvent.Register<Item> _itemRegistryEvent) {
        
    }

    public String getOreName() {
        return oreName;
    }

    public Item getItem() {
        return item;
    }

}
