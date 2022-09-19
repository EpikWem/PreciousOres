
package com.epikwem.preciousores.init;

import com.epikwem.preciousores.PreciousOres;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PreciousOres.MOD_ID);

    public static final Block BLAZINGGOLD_BLOCK = registerBlock( "blazinggold_block",
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).strength(3.0f, 12.0f)));
    public static final DropExperienceBlock BLAZINGGOLD_ORE = registerBlock( "blazinggold_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).strength(6.0f, 6.0f).requiresCorrectToolForDrops().lightLevel((state) -> 3)));
    public static final Block OBSIDIANITE_BLOCK = registerBlock("obsidianite_block",
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLACK).strength(60.0f, 1200.0f)));
    public static final Block SHININGGOLD_BLOCK = registerBlock( "shininggold_block",
            new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.GOLD).strength(0.5f).sound(SoundType.GLASS).lightLevel((state) -> 15)));
    public static final DropExperienceBlock SHININGGOLD_ORE = registerBlock("shininggold_ore",
        new DropExperienceBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.GOLD).strength(2.4f).sound(SoundType.GLASS).requiresCorrectToolForDrops().lightLevel((state) -> 14), UniformInt.of(3, 6)));

    // silver
    public static final Block SILVER_BLOCK = registerBlock( "silver_block",
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)));
    public static final DropExperienceBlock SILVER_ORE = registerBlock( "silver_ore",
            new DropExperienceBlock( BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.NETHER_ORE).strength(7.0f, 3.0f).requiresCorrectToolForDrops()));

    public static <B extends Block> B registerBlock(final String _name, final B _block)
    {
        BLOCKS.register(_name, () -> _block);
        ModItems.registerBlockItem(_block);
        PreciousOres.LOGGER.info("|========= Registered the Block: "+ _name);
        return _block;
    }

    public static void register(final IEventBus _event_bus)
    {
        BLOCKS.register(_event_bus);
    }


}
