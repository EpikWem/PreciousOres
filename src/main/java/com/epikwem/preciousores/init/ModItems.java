
package com.epikwem.preciousores.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class ModItems {

    public static final Item
            SILVER_INGOT = ModItem(),
            SILVER_NUGGET = ModItem();



    private static Item ModItem() {
        return new Item(new Item.Properties().group(ItemGroup.MATERIALS));
    }

}
