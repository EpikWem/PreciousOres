package com.epikwem.preciousores.world.feature;

import com.epikwem.preciousores.PreciousOres;
import com.epikwem.preciousores.init.ModBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.Registry;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures
{

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, PreciousOres.MOD_ID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>>
            BLAZINGGOLD_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(ModOreFeatures.MAGMA_BLOCK, ModBlocks.BLAZINGGOLD_ORE.get().defaultBlockState()))),
            SHININGGOLD_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(ModOreFeatures.GLOWSTONE, ModBlocks.SHININGGOLD_ORE.get().defaultBlockState()))),
            SILVER_ORES = Suppliers.memoize(() -> List.of(OreConfiguration.target(ModOreFeatures.BLACKSTONE, ModBlocks.SILVER_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>>
            BLAZINGGOLD_ORES_CONFIGURATION = CONFIGURED_FEATURES.register("blazinggold_ores", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BLAZINGGOLD_ORES.get(), 7))),
            SHININGGOLD_ORES_CONFIGURATION = CONFIGURED_FEATURES.register("blazinggold_ores", () -> new ConfiguredFeature<>(Feature.ORE,  new OreConfiguration(SHININGGOLD_ORES.get(), 7))),
            SILVER_ORES_CONFIGURATION = CONFIGURED_FEATURES.register("blazinggold_ores", () -> new ConfiguredFeature<>(Feature.ORE,  new OreConfiguration(SILVER_ORES.get(), 7)));

    public static void register(final IEventBus _event_bus)
    {
        CONFIGURED_FEATURES.register(_event_bus);
    }

    private static class ModOreFeatures
    {
        private static final RuleTest
            BLACKSTONE = new BlockMatchTest(Blocks.BLACKSTONE),
            GLOWSTONE = new BlockMatchTest(Blocks.GLOWSTONE),
            MAGMA_BLOCK = new BlockMatchTest(Blocks.MAGMA_BLOCK);
    }

}
