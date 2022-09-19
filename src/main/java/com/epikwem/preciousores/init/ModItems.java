
package com.epikwem.preciousores.init;

import com.epikwem.preciousores.PreciousOres;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PreciousOres.MOD_ID);

    public static final RegistryObject<Item>
            BLAZINGGOLD_INGOT = registerItem("blazinggold_ingot"),
            BLAZINGGOLD_NUGGET = registerItem("blazinggold_nugget"),
            OBSIDIANITE = registerItem("obsidianite"),
            SHININGGOLD_CRYSTAL = registerItem("shininggold_crystal"),
            SHININGGOLD_SHARD = registerItem("shininggold_shard"),
            SILVER_INGOT = registerItem("silver_ingot"),
            SILVER_NUGGET = registerItem("silver_nugget");



    private static RegistryObject<Item> registerItem(String _name)
    {
        return registerItem(_name, () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    }

    private static <I extends Item> RegistryObject<I> registerItem(String _name, Supplier<I> _item)
    {
        PreciousOres.LOGGER.info("|========= Registered the Item: "+ _name);
        return ITEMS.register(_name, _item);
    }

    public static void register(IEventBus _event_bus)
    {
        ITEMS.register(_event_bus);
    }


}
