package nova.committee.avaritia.init.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.common.block.CompressorBlock;
import nova.committee.avaritia.common.block.ExtremeCraftingTableBlock;
import nova.committee.avaritia.common.block.NeutronCollectorBlock;
import nova.committee.avaritia.common.block.ResourceBlock;
import nova.committee.avaritia.common.block.craft.CompressedCraftingTableBlock;
import nova.committee.avaritia.common.block.craft.DoubleCompressedCraftingTableBlock;
import nova.committee.avaritia.util.RegistryUtil;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 6:47
 * Version: 1.0
 */
@Mod.EventBusSubscriber(modid = Static.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static Block compressed_crafting_table;
    public static Block double_compressed_crafting_table;

    public static Block neutronium;
    public static Block infinity;
    public static Block crystal_matrix;

    public static Block extreme_crafting_table;
    public static Block neutron_collector;
    public static Block compressor;


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        registry.registerAll(
                compressed_crafting_table = new CompressedCraftingTableBlock(),
                double_compressed_crafting_table = new DoubleCompressedCraftingTableBlock(),
                extreme_crafting_table = new ExtremeCraftingTableBlock(),
                neutron_collector = new NeutronCollectorBlock(),

                neutronium = new ResourceBlock("neutronium"),
                infinity = new ResourceBlock("infinity"),
                crystal_matrix = new ResourceBlock("crystal_matrix"),
                compressor = new CompressorBlock()
        );

    }

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                RegistryUtil.blockItem(compressed_crafting_table),
                RegistryUtil.blockItem(double_compressed_crafting_table),
                RegistryUtil.blockItem(extreme_crafting_table),
                RegistryUtil.blockItem(neutron_collector),
                RegistryUtil.blockItem(compressor),

                RegistryUtil.blockItem(neutronium),
                RegistryUtil.blockItem(infinity),
                RegistryUtil.blockItem(crystal_matrix)
        );
    }
}