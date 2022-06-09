package nova.committee.avaritia.init.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.common.tile.CompressorTileEntity;
import nova.committee.avaritia.common.tile.ExtremeCraftingTile;
import nova.committee.avaritia.common.tile.NeutronCollectorTile;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 9:48
 * Version: 1.0
 */
//@Mod.EventBusSubscriber(modid = Static.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTileEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Static.MOD_ID);

    public static void init() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCK_ENTITIES.register(bus);
    }

    public static RegistryObject<BlockEntityType<ExtremeCraftingTile>> extreme_crafting_tile = BLOCK_ENTITIES.register("extreme_crafting_tile", () ->
            BlockEntityType.Builder.of(ExtremeCraftingTile::new, ModBlocks.extreme_crafting_table.get()).build(null));
    public static RegistryObject<BlockEntityType<NeutronCollectorTile>> neutron_collector_tile = BLOCK_ENTITIES.register("neutron_collector_tile", () ->
            BlockEntityType.Builder.of(NeutronCollectorTile::new, ModBlocks.neutron_collector.get()).build(null));
    public static RegistryObject<BlockEntityType<CompressorTileEntity>> compressor_tile = BLOCK_ENTITIES.register("compressor_tile", () ->
            BlockEntityType.Builder.of(CompressorTileEntity::new, ModBlocks.compressor.get()).build(null));

//    public static RegistryObject<BlockEntityType<InfinitatoTile>> infinitato_tileBLOCK_ENTITIES.register("tutorial_block_entity", () ->
//            BlockEntityType.Builder.of(TutorialBlockEntity::new, TutorialBlocks.TUTORIAL_BLOCK.get()).build(null));


//    @SubscribeEvent
//    public static void registerBlocks(RegistryEvent.Register<BlockEntityType<?>> event) {
//        final IForgeRegistry<BlockEntityType<?>> registry = event.getRegistry();
//
//        registry.registerAll(
//                extreme_crafting_tile = RegistryUtil.build(ExtremeCraftingTile::new, "extreme_crafting_tile", ModBlocks.extreme_crafting_table),
//                neutron_collector_tile = RegistryUtil.build(NeutronCollectorTile::new, "neutron_collector_tile", ModBlocks.neutron_collector),
//                compressor_tile = RegistryUtil.build(CompressorTileEntity::new, "compressor_tile", ModBlocks.compressor)
//                //infinitato_tile = RegistryUtil.build(InfinitatoTile::new, "infinitato_tile", ModBlocks.infinitato)
//
//
//        );
//
//    }
}
