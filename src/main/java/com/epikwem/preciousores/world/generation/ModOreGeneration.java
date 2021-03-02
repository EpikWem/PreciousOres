
// https://youtu.be/ZLBrtsW10eA
// fill ~-20 ~-10 ~-20 ~20 ~8 ~20 air replace minecraft:netherrack

package com.epikwem.preciousores.world.generation;

import com.epikwem.preciousores.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;


public class ModOreGeneration {

    public static void generateOres(final BiomeLoadingEvent _event) {
        if (_event.getCategory().equals(Biome.Category.NETHER)) {
            registerNetherOre(_event.getGeneration(), ModBlocks.SILVER_ORE, 8, 128, 16);
        } if ( !(_event.getCategory().equals(Biome.Category.NETHER)) && !(_event.getCategory().equals(Biome.Category.NETHER)) ) {
            registerOverworldOre(_event.getGeneration(), ModBlocks.SILVER_ORE, 8, 128, 16);
        }
    }

    private static void registerNetherOre(BiomeGenerationSettingsBuilder _settings, final Block _oreBlock, int _veinSize, int _maxHeight, int _frequency) {
        _settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
            Feature.ORE.withConfiguration(
                new OreFeatureConfig(
                    FillerBlockType.NETHERRACK,
                    _oreBlock.getDefaultState(),
                    _veinSize )
            ).withPlacement(
                Placement.RANGE.configure(new TopSolidRangeConfig(4, 0, _maxHeight))
            ).func_242731_b(
                _frequency
            ).square()
        );
    }

    private static void registerOverworldOre(BiomeGenerationSettingsBuilder _settings, final Block _oreBlock, int _veinSize, int _maxHeight, int _frequency) {
        _settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
            Feature.ORE.withConfiguration(
                new OreFeatureConfig(
                        FillerBlockType.BASE_STONE_OVERWORLD,
                        _oreBlock.getDefaultState(),
                        _veinSize )
            ).withPlacement(
                Placement.RANGE.configure(new TopSolidRangeConfig(4, 0, _maxHeight))
            ).func_242731_b(
                _frequency
            ).square()
        );
    }

}
