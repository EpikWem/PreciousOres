
package com.epikwem.preciousores.init;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class ModBlocks {

    // blazing gold
    public static final Block BLAZINGGOLD_BLOCK = ModBlock(MaterialColor.GOLD, 3.0f, 12.0f);
    public static final OreBlock BLAZINGGOLD_ORE = ModOreBlock(MaterialColor.GOLD, 6.0f, 3.0f, 2);

    // shining gold
    public static final Block SHININGGOLD_BLOCK = ModBlock(MaterialColor.GOLD, 2.0f, 1.0f);
    public static final OreBlock SHININGGOLD_ORE = ModOreBlock(MaterialColor.GOLD, 5.0f, 2.0f, 2);

    // silver
    public static final Block SILVER_BLOCK = ModBlock(MaterialColor.LIGHT_GRAY, 3.0f, 6.0f);
    public static final OreBlock SILVER_ANDESITE_ORE = ModOreBlock(MaterialColor.LIGHT_GRAY, 9.0f, 4.0f, 2);
    public static final OreBlock SILVER_DIORITE_ORE = ModOreBlock(MaterialColor.LIGHT_GRAY, 9.0f, 4.0f, 2);
    public static final OreBlock SILVER_GRANITE_ORE = ModOreBlock(MaterialColor.LIGHT_GRAY, 9.0f, 4.0f, 2);
    public static final OreBlock SILVER_ORE = ModOreBlock(MaterialColor.LIGHT_GRAY, 7.0f, 3.0f, 2);
    public static final OreBlock SILVER_STONE_ORE = ModOreBlock(MaterialColor.LIGHT_GRAY, 9.0f, 4.0f, 2);



    private static Block ModBlock(MaterialColor _color, float _hardness, float _resistance) {
        return new Block( Block.Properties
            .create(Material.IRON, _color)
            .sound(SoundType.METAL)
            .hardnessAndResistance(_hardness, _resistance)
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
        );
    }

    private static OreBlock ModOreBlock(MaterialColor _color, float _hardness, float _resistance, int _harvestLevel) {
        return new OreBlock( Block.Properties
                .create(Material.ROCK, _color)
                .sound(SoundType.NETHER_ORE)
                .hardnessAndResistance(_hardness, _resistance)
                .harvestLevel(_harvestLevel)
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
