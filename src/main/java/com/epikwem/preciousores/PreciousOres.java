package com.epikwem.preciousores;

import com.epikwem.preciousores.init.ModBlocks;
import com.epikwem.preciousores.init.ModItems;
import com.epikwem.preciousores.world.feature.ModConfiguredFeatures;
import com.epikwem.preciousores.world.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(PreciousOres.MOD_ID)
public class PreciousOres
{
    public static final String MOD_ID = "preciousores";
    public static final Logger LOGGER = LogManager.getLogger();

    public PreciousOres()
    {
        final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(MOD_EVENT_BUS);
        ModItems.register(MOD_EVENT_BUS);
        ModConfiguredFeatures.register(MOD_EVENT_BUS);
        ModPlacedFeatures.register(MOD_EVENT_BUS);

        MOD_EVENT_BUS.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent _event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP!");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent _event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP!");
        }
    }


}
