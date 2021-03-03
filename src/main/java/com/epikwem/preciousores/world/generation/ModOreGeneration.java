
// https://youtu.be/ZLBrtsW10eA
// fill ~-20 ~-10 ~-20 ~20 ~8 ~20 air replace minecraft:netherrack

package com.epikwem.preciousores.world.generation;

import com.epikwem.preciousores.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;


public class ModOreGeneration {

    public static void generateOres(final BiomeLoadingEvent _event) {
        // if in NETHER
        if (_event.getCategory().equals(Biome.Category.NETHER)) {
            registerOre(_event.getGeneration(), ModBlocks.SILVER_ORE, 5, 128, 6, FillerBlockType.NETHERRACK);
        }
        // if in OVERWORLD
        if ( !(_event.getCategory().equals(Biome.Category.NETHER)) && !(_event.getCategory().equals(Biome.Category.NETHER)) ) {
            registerOre(_event.getGeneration(), ModBlocks.SILVER_ANDESITE_ORE, 4, 24, 4, ModFillerBlockTypes.ANDESITE);
            registerOre(_event.getGeneration(), ModBlocks.SILVER_DIORITE_ORE, 4, 24, 4, ModFillerBlockTypes.DIORITE);
            registerOre(_event.getGeneration(), ModBlocks.SILVER_GRANITE_ORE, 4, 24, 4, ModFillerBlockTypes.GRANITE);
            registerOre(_event.getGeneration(), ModBlocks.SILVER_STONE_ORE, 4, 24, 4, ModFillerBlockTypes.STONE);
        }
    }

    private static void registerOre(BiomeGenerationSettingsBuilder _settings, final Block _oreBlock, int _veinSize, int _maxHeight, int _frequency, final RuleTest _fillerBlock) {
        _settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
            Feature.ORE.withConfiguration(
                new OreFeatureConfig(
                    _fillerBlock,
                    _oreBlock.getDefaultState(),
                    _veinSize)
            ).withPlacement(
                Placement.RANGE.configure(new TopSolidRangeConfig(4, 0, _maxHeight))
            ).func_242731_b(
                _frequency
            ).square()
        );
    }

}
