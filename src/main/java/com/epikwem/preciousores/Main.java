package com.epikwem.preciousores;

import com.epikwem.preciousores.init.ModOreItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)
public class Main
{
    public static final String MODID = "preciousores";
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupEvent);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupEvent(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> _blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
            _blockRegistryEvent.getRegistry().registerAll(
                    ModOreItemTier.SILVER.setupBlock(true),
                    ModOreItemTier.SILVER.setupBlock(false)
            );
            LOGGER.info("Block registering FINISHED");
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> _itemRegistryEvent) {
            LOGGER.info("HELLO from Register Item");
            _itemRegistryEvent.getRegistry().registerAll(
                    ModOreItemTier.SILVER.setupItem("ingot"),
                    ModOreItemTier.SILVER.setupItem("nugget"),
                    ModOreItemTier.SILVER.setupSword(),
                    ModOreItemTier.SILVER.setupTool(ToolType.PICKAXE),
                    ModOreItemTier.SILVER.setupTool(ToolType.AXE),
                    ModOreItemTier.SILVER.setupTool(ToolType.SHOVEL),
                    ModOreItemTier.SILVER.setupTool(ToolType.HOE)
            );
            for (final Block block : ForgeRegistries.BLOCKS.getValues()) {
                final BlockItem blockItem = new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
                blockItem.setRegistryName(block.getRegistryName());
                _itemRegistryEvent.getRegistry().register(blockItem);
            }
            LOGGER.info("Item registering FINISHED");
        }

    } // end of RegistryEvent

    // to register an entry (block, item...)
    public static <T extends IForgeRegistryEntry<T>> T setup(final String _name, final T _entry) {
        LOGGER.info("    setup("+ _name+ ")");
        return _entry.setRegistryName(new ResourceLocation(Main.MODID, _name));
    }

    private static <T extends IForgeRegistryEntry<T>> T setup(final ResourceLocation _registryName, final T _entry) {
        return _entry.setRegistryName(_registryName);
    }

}
