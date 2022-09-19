
package com.epikwem.preciousores.init;

import com.epikwem.preciousores.PreciousOres;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PreciousOres.MOD_ID);

    public static final RegistryObject<Block> BLAZINGGOLD_BLOCK = registerBlock( "blazinggold_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).strength(3.0f, 12.0f)));
    public static final RegistryObject<DropExperienceBlock> BLAZINGGOLD_ORE = registerBlock( "blazinggold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).strength(6.0f, 6.0f).requiresCorrectToolForDrops().lightLevel((state) -> 3)));
    public static final RegistryObject<Block> OBSIDIANITE_BLOCK = registerBlock("obsidianite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLACK).strength(60.0f, 1200.0f).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> SHININGGOLD_BLOCK = registerBlock( "shininggold_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GOLD).strength(0.5f).lightLevel((state) -> 15)));
    public static final RegistryObject<DropExperienceBlock> SHININGGOLD_ORE = registerBlock("shininggold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.GOLD).strength(2.4f).sound(SoundType.GLASS).requiresCorrectToolForDrops().lightLevel((state) -> 14), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock( "silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<DropExperienceBlock> SILVER_ORE = registerBlock( "silver_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.NETHER_ORE).strength(7.0f, 3.0f).requiresCorrectToolForDrops()));

    public static <B extends Block> RegistryObject<B> registerBlock(String _name, Supplier<B> _block)
    {
        PreciousOres.LOGGER.info("|========= Registered the Block: "+ _name);
        RegistryObject<B> result = BLOCKS.register(_name, _block);
        ModItems.ITEMS.register(_name, () -> new BlockItem(result.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        return result;
    }

    public static void register(final IEventBus _event_bus)
    {
        BLOCKS.register(_event_bus);
    }


}
