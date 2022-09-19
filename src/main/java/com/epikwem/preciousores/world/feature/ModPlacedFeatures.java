package com.epikwem.preciousores.world.feature;

import com.epikwem.preciousores.PreciousOres;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures
{

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PreciousOres.MOD_ID);

    public static final RegistryObject<PlacedFeature> BLAZINGGOLD_ORE_PLACED = PLACED_FEATURES.register( "blazinggold_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLAZINGGOLD_ORES_CONFIGURATION.getHolder().get(),
                    commonOrePlacement(7 , HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));
    public static final RegistryObject<PlacedFeature> SHININGGOLD_ORE_PLACED = PLACED_FEATURES.register( "shininggold_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SHININGGOLD_ORES_CONFIGURATION.getHolder().get(),
                    commonOrePlacement(7 , HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));
    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = PLACED_FEATURES.register( "silver_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORES_CONFIGURATION.getHolder().get(),
                    commonOrePlacement(7 , HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))));

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(final IEventBus _event_bus)
    {
        PLACED_FEATURES.register(_event_bus);
    }

}
