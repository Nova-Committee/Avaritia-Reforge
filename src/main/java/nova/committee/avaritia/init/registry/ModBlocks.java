package nova.committee.avaritia.init.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.common.block.CompressorBlock;
import nova.committee.avaritia.common.block.ExtremeCraftingTableBlock;
import nova.committee.avaritia.common.block.NeutronCollectorBlock;
import nova.committee.avaritia.common.block.ResourceBlock;
import nova.committee.avaritia.common.block.craft.CompressedCraftingTableBlock;
import nova.committee.avaritia.common.block.craft.DoubleCompressedCraftingTableBlock;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 6:47
 * Version: 1.0
 */
public class ModBlocks {


    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Static.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Static.MOD_ID);

    public static RegistryObject<Block> compressed_crafting_table = BLOCKS.register("compressed_crafting_table", CompressedCraftingTableBlock::new);
    public static RegistryObject<Item> compressed_crafting_table_ = formItem("compressed_crafting_table", compressed_crafting_table);
    public static RegistryObject<Block> double_compressed_crafting_table = BLOCKS.register("double_compressed_crafting_table", DoubleCompressedCraftingTableBlock::new);
    public static RegistryObject<Item> double_compressed_crafting_table_ = formItem("double_compressed_crafting_table", double_compressed_crafting_table);
    public static RegistryObject<Block> neutronium = BLOCKS.register("neutronium", () -> new ResourceBlock(SoundType.METAL));
    public static RegistryObject<Item> neutronium_ = formItem("neutronium", neutronium);
    public static RegistryObject<Block> infinity = BLOCKS.register("infinity", () -> new ResourceBlock(SoundType.METAL));
    public static RegistryObject<Item> infinity_ = formItem("infinity", infinity);
    //public static RegistryObject<Block> infinitato = BLOCKS.register("infinitato", CompressedCraftingTableBlock::new);
    public static RegistryObject<Block> crystal_matrix = BLOCKS.register("crystal_matrix", () -> new ResourceBlock(SoundType.GLASS));
    public static RegistryObject<Item> crystal_matrix_ = formItem("crystal_matrix", crystal_matrix);
    public static RegistryObject<Block> extreme_crafting_table = BLOCKS.register("extreme_crafting_table", ExtremeCraftingTableBlock::new);
    public static RegistryObject<Item> extreme_crafting_table_ = formItem("extreme_crafting_table", extreme_crafting_table);
    public static RegistryObject<Block> neutron_collector = BLOCKS.register("neutron_collector", NeutronCollectorBlock::new);
    public static RegistryObject<Item> neutron_collector_ = formItem("neutron_collector", neutron_collector);
    public static RegistryObject<Block> compressor = BLOCKS.register("neutronium_compressor", CompressorBlock::new);
    public static RegistryObject<Item> compressor_ = formItem("neutronium_compressor", compressor);

    private static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(ModTab.TAB);
    }

    private static RegistryObject<Item> formItem(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), defaultItemProperties()));
    }

    public static void init() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }


//    @SubscribeEvent
//    public static void registerBlocks(RegistryEvent.Register<Block> event) {
//        final IForgeRegistry<Block> registry = event.getRegistry();
//
//        registry.registerAll(
//                compressed_crafting_table = new CompressedCraftingTableBlock(),
//                double_compressed_crafting_table = new DoubleCompressedCraftingTableBlock(),
//                extreme_crafting_table = new ExtremeCraftingTableBlock(),
//                neutron_collector = new NeutronCollectorBlock(),
//
//                neutronium = new ResourceBlock(SoundType.METAL, "neutronium"),
//                infinity = new ResourceBlock(SoundType.METAL, "infinity"),
//                crystal_matrix = new ResourceBlock(SoundType.GLASS, "crystal_matrix"),
//                compressor = new CompressorBlock()
//                //infinitato = new InfinitatoBlock()
//        );
//    }
//
//    @SubscribeEvent
//    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
//        final IForgeRegistry<Item> registry = event.getRegistry();
//        registry.registerAll(
//                RegistryUtil.blockItem(compressed_crafting_table, Rarity.COMMON),
//                RegistryUtil.blockItem(double_compressed_crafting_table, Rarity.UNCOMMON),
//                RegistryUtil.blockItem(extreme_crafting_table, ModItems.COSMIC_RARITY),
//                RegistryUtil.blockItem(neutron_collector, Rarity.EPIC),
//                RegistryUtil.blockItem(compressor, Rarity.EPIC),
//
//                RegistryUtil.blockItem(neutronium, Rarity.EPIC),
//                RegistryUtil.blockItem(infinity, ModItems.COSMIC_RARITY),
//                RegistryUtil.blockItem(crystal_matrix, Rarity.RARE)
//                //RegistryUtil.blockItem(infinitato)
//        );
//    }
}
