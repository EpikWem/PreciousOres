
package com.epikwem.preciousores.init;

import com.epikwem.preciousores.PreciousOres;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PreciousOres.MOD_ID);

    public static final Item
            BLAZINGGOLD_INGOT = registerItem("blazinggold_ingot"),
            BLAZINGGOLD_NUGGET = registerItem("blazinggold_nugget"),
            OBSIDIANITE = registerItem("obsidianite"),
            SHININGGOLD_CRYSTAL = registerItem("shininggold_crystal"),
            SHININGGOLD_SHARD = registerItem("shininggold_shard"),
            SILVER_INGOT = registerItem("silver_ingot"),
            SILVER_NUGGET = registerItem("silver_nugget");



    public static Item registerItem(final String _name)
    {
        final Item item = new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS));
        registerItem(_name, item);
        return item;
    }

    public static <B extends Block> void registerBlockItem(final B _block)
    {
        final Item item = new Item(new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
        final String name = _block.getName().getString();
        registerItem(_block.getName().getString(), item);
    }

    public static <I extends Item> I registerItem(final String _name, final I _item)
    {
        ITEMS.register(_name, () -> _item);
        PreciousOres.LOGGER.info("|========= Registered the Item: "+ _name);
        return _item;
    }

    public static void register(final IEventBus _event_bus)
    {
        ITEMS.register(_event_bus);
    }


}
