
package com.epikwem.preciousores.generation;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    private class ModOreFeatures extends ConfiguredFeature {

    }
    private final ConfiguredFeature SILVER_ORE = OreGenUtils.buildNetherOreFeature(
            Feature.ORE, ModBlocks.onyx_ore.get().getDefaultState(),
            SimpleOresConfig.onyx_cfg);

    public static void generateNetherOres(BiomeLoadingEvent event) {
        event.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.SILVER_ORE);
    }

}
