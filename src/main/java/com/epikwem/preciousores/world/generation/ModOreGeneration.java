
package com.epikwem.preciousores.world.generation;

import com.epikwem.preciousores.Main;
import com.epikwem.preciousores.init.ModOreBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGeneration {

    public static void generateOres() {
        registerOre("silver_ore", modNetherOreFeature(ModOreBlocks.SILVER, 8, 64, 16));
    }

    private static void registerOre(String _name, final ConfiguredFeature _feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Main.MODID+":"+_name, _feature);
    }

    private static ConfiguredFeature modNetherOreFeature(final ModOreBlocks _oreBlock, int _veinSize, int _maxHeight, int _frequency) {
        return Feature.ORE.withConfiguration( new OreFeatureConfig(
                FillerBlockType.NETHERRACK,
                _oreBlock.getOreBlock().getDefaultState(),
                _veinSize ))
                .range(_maxHeight) // Maximum Spawn Height
                .square()
                .func_242731_b(_frequency); // Chunk Spawn Frequency
    }

}
