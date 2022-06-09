package nova.committee.avaritia.init.registry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.client.screen.CompressorScreen;
import nova.committee.avaritia.client.screen.ExtremeCraftingScreen;
import nova.committee.avaritia.client.screen.NeutronCollectorScreen;
import nova.committee.avaritia.common.menu.CompressorMenu;
import nova.committee.avaritia.common.menu.ExtremeCraftingMenu;
import nova.committee.avaritia.common.menu.NeutronCollectorMenu;

//@Mod.EventBusSubscriber(modid = Static.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModMenus {
    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Static.MOD_ID);

    public static void init() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        MENUS.register(bus);
    }

    public static RegistryObject<MenuType<ExtremeCraftingMenu>> extreme_crafting_table = MENUS.register("extreme_crafting_table", () -> IForgeMenuType.create(ExtremeCraftingMenu::create));

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
        MenuScreens.register(extreme_crafting_table.get(), ExtremeCraftingScreen::new);
        MenuScreens.register(neutron_collector.get(), NeutronCollectorScreen::new);
        MenuScreens.register(compressor.get(), CompressorScreen::new);

    }

    public static RegistryObject<MenuType<NeutronCollectorMenu>> neutron_collector = MENUS.register("neutron_collector", () -> IForgeMenuType.create(NeutronCollectorMenu::create));
    public static RegistryObject<MenuType<CompressorMenu>> compressor = MENUS.register("compressor", () -> IForgeMenuType.create(CompressorMenu::create));


//    @SubscribeEvent
//    public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
//        final IForgeRegistry<MenuType<?>> registry = event.getRegistry();
//
//        registry.registerAll(
//                extreme_crafting_table = RegistryUtil.registerContainer("extreme_crafting_table", ExtremeCraftingMenu::create),
//                neutron_collector = RegistryUtil.registerContainer("neutron_collector", NeutronCollectorMenu::create),
//                compressor = RegistryUtil.registerContainer("compressor", CompressorMenu::create)
//
//        );
//    }


}
