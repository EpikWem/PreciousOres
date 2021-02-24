
package com.epikwem.preciousores.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class ModBlocks {

    public static final Block
    SILVER_ORE = new OreBlock( Block.Properties
            .create(Material.ROCK, MaterialColor.LIGHT_GRAY)
            .hardnessAndResistance(5.0f, 4.0f)
            .harvestLevel(2).harvestTool(ToolType.PICKAXE) ),
    SILVER_BLOCK = new Block( Block.Properties
            .create(Material.IRON, MaterialColor.LIGHT_GRAY)
            .hardnessAndResistance(10.0f, 9.0f)
            .harvestLevel(2).harvestTool(ToolType.PICKAXE) );

}
