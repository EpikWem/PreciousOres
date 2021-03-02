
package com.epikwem.preciousores.world.generation;

import com.epikwem.preciousores.Main;
import com.epikwem.preciousores.init.ModOreBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ModOreGeneration {
//https://youtu.be/ZLBrtsW10eA

    public static void registerOresOnSetup() {
        NETHER_ORES.add( modNetherOreFeature(ModOreBlocks.SILVER, 8, 128, 24) );
    }

    private static final ArrayList<ConfiguredFeature<?,?>> NETHER_ORES = new ArrayList<ConfiguredFeature<?,?>>();

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void generateOres(BiomeLoadingEvent _event) {
        BiomeGenerationSettingsBuilder generation = _event.getGeneration();
        if (_event.getCategory().equals(Biome.Category.NETHER)) {
            for (ConfiguredFeature<?,?> ore : NETHER_ORES) {
                if (ore != null)
                    generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC,?> registerOre(String _name, ConfiguredFeature<FC,?> _feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Main.MODID+":"+_name, _feature);
    }

    private static ConfiguredFeature<?,?> modNetherOreFeature(final ModOreBlocks _oreBlock, int _veinSize, int _maxHeight, int _frequency) {
        return Feature.ORE.withConfiguration(
                new OreFeatureConfig(
                        FillerBlockType.NETHERRACK,
                        _oreBlock.getOreBlock().getDefaultState(),
                        _veinSize )
        ).range(_maxHeight) // Maximum Spawn Height
                .square()
                .func_242731_b(_frequency); // Chunk Spawn Frequency
    }

}
