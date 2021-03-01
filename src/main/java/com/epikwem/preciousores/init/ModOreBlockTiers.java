
package com.epikwem.preciousores.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;

import static com.epikwem.preciousores.Main.setup;

public enum ModOreBlockTiers {

    SILVER(ModIngots.SILVER_INGOT, MaterialColor.LIGHT_GRAY, 6.0f, 3.0f, 3);

    private final String oreName;
    private final MaterialColor color;
    private final float hardness;
    private final float resistance;
    private final int harvestLevel;

    ModOreBlockTiers(final ModIngots _oreIngot, final MaterialColor _color, final float _hardness, final float _resistance, final int _harvestLevel) {
        oreName = _oreIngot.getOreName();
        color = _color;
        hardness = _hardness;
        resistance = _resistance;
        harvestLevel = _harvestLevel;
    }

    public void registerOreBlocks(final RegistryEvent.Register<Block> _blockRegistryEvent) {
        _blockRegistryEvent.getRegistry().registerAll(
            setup(oreName+"_ore", new OreBlock( Block.Properties
                        .create(Material.ROCK, color)
                        .sound(SoundType.NETHER_ORE)
                        .hardnessAndResistance(hardness, resistance)
                        .harvestLevel(harvestLevel)
                        .harvestTool(ToolType.PICKAXE) )
            ),
            setup(oreName+"_block", new Block( Block.Properties
                        .create(Material.IRON, color)
                        .sound(SoundType.METAL)
                        .hardnessAndResistance(hardness+2.0f, 3.0f + 0.5f*resistance)
                        .harvestLevel(0)
                        .harvestTool(ToolType.PICKAXE) )
            )
        );
    }

}
