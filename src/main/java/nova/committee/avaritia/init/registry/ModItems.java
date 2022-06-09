package nova.committee.avaritia.init.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.common.item.ArmorInfinityItem;
import nova.committee.avaritia.common.item.EndestPearlItem;
import nova.committee.avaritia.common.item.MatterClusterItem;
import nova.committee.avaritia.common.item.resources.ResourceItem;
import nova.committee.avaritia.common.item.resources.StarFuelItem;
import nova.committee.avaritia.common.item.singularity.SingularityItem;
import nova.committee.avaritia.common.item.tools.*;
import nova.committee.avaritia.init.ModFoods;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/3/31 11:36
 * Version: 1.0
 */
//@Mod.EventBusSubscriber(modid = Static.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Static.MOD_ID);

    public static Rarity COSMIC_RARITY = Rarity.create("COSMIC", ChatFormatting.RED);

    //tools
    public static RegistryObject<Item> pick_axe = ITEMS.register("infinity_pickaxe", PickaxeInfinityItem::new);
    public static RegistryObject<Item> infinity_shovel = ITEMS.register("infinity_shovel", ShovelInfinityItem::new);
    public static RegistryObject<Item> infinity_axe = ITEMS.register("infinity_axe", AxeInfinityItem::new);

    public static RegistryObject<Item> infinity_hoe = ITEMS.register("infinity_hoe", HoeInfinityItem::new);
    public static RegistryObject<Item> matter_cluster = ITEMS.register("matter_cluster", MatterClusterItem::new);


    //weapons
    public static RegistryObject<Item> infinity_sword = ITEMS.register("infinity_sword", SwordInfinityItem::new);
    public static RegistryObject<Item> skull_sword = ITEMS.register("skull_fire_sword", SwordSkullsItem::new);
    public static RegistryObject<Item> infinity_bow = ITEMS.register("infinity_bow", BowInfinityItem::new);


    //armors
    public static RegistryObject<Item> infinity_helmet = ITEMS.register("infinity_helmet", () -> new ArmorInfinityItem(EquipmentSlot.HEAD));
    public static RegistryObject<Item> infinity_chestplate = ITEMS.register("infinity_chestplate", () -> new ArmorInfinityItem(EquipmentSlot.CHEST));
    public static RegistryObject<Item> infinity_pants = ITEMS.register("infinity_pants", () -> new ArmorInfinityItem(EquipmentSlot.LEGS));
    public static RegistryObject<Item> infinity_boots = ITEMS.register("infinity_boots", () -> new ArmorInfinityItem(EquipmentSlot.FEET));


    public static RegistryObject<Item> ultimate_stew = ITEMS.register("ultimate_stew", () -> new Item(new Item.Properties().tab(ModTab.TAB).rarity(Rarity.EPIC).food(ModFoods.ultimate_stew)));
    public static RegistryObject<Item> cosmic_meatballs = ITEMS.register("cosmic_meatballs", () -> new Item(new Item.Properties().tab(ModTab.TAB).rarity(Rarity.EPIC).food(ModFoods.cosmic_meatballs)));
    public static RegistryObject<Item> endest_pearl = ITEMS.register("endest_pearl", EndestPearlItem::new);


    public static RegistryObject<Item> diamond_lattice = ITEMS.register("diamond_lattice", () -> new ResourceItem(Rarity.UNCOMMON, "diamond_lattice", false));
    public static RegistryObject<Item> crystal_matrix_ingot = ITEMS.register("crystal_matrix_ingot", () -> new ResourceItem(Rarity.RARE, "crystal_matrix_ingot", true));
    public static RegistryObject<Item> neutron_pile = ITEMS.register("neutron_pile", () -> new ResourceItem(Rarity.UNCOMMON, "neutron_pile", true));
    public static RegistryObject<Item> neutron_nugget = ITEMS.register("neutron_nugget", () -> new ResourceItem(Rarity.UNCOMMON, "neutron_nugget", true));
    public static RegistryObject<Item> neutronium_ingot = ITEMS.register("neutronium_ingot", () -> new ResourceItem(Rarity.RARE, "neutronium_ingot", true));
    public static RegistryObject<Item> neutronium_gear = ITEMS.register("neutronium_gear", () -> new ResourceItem(Rarity.EPIC, "neutronium_gear", true));

    public static RegistryObject<Item> infinity_nugget = ITEMS.register("infinity_nugget", () -> new ResourceItem(Rarity.RARE, "infinity_nugget", true));
    public static RegistryObject<Item> infinity_catalyst = ITEMS.register("infinity_catalyst", () -> new ResourceItem(Rarity.EPIC, "infinity_catalyst", true));
    public static RegistryObject<Item> infinity_ingot = ITEMS.register("infinity_ingot", () -> new ResourceItem(COSMIC_RARITY, "infinity_ingot", true));

    public static RegistryObject<Item> star_fuel = ITEMS.register("star_fuel", () -> new StarFuelItem(Rarity.EPIC));
    public static RegistryObject<Item> record_fragment = ITEMS.register("record_fragment", () -> new ResourceItem(Rarity.UNCOMMON, "record_fragment", true));

    public static RegistryObject<Item> singularity = ITEMS.register("singularity", () -> new SingularityItem(p -> p.tab(ModTab.TAB)));


    public static void init() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

//    @SubscribeEvent
//    public static void registerItems(RegistryEvent.Register<Item> event) {
//        final IForgeRegistry<Item> registry = event.getRegistry();
//
//        registry.registerAll(
//                pick_axe = new PickaxeInfinityItem(),
//                matter_cluster = new MatterClusterItem(),
//                infinity_shovel = new ShovelInfinityItem(),
//                infinity_hoe = new HoeInfinityItem(),
//                infinity_axe = new AxeInfinityItem(),
//
//                infinity_sword = new SwordInfinityItem(),
//                skull_sword = new SwordSkullsItem(),
//                infinity_bow = new BowInfinityItem(),
//
//                infinity_helmet = new ArmorInfinityItem(EquipmentSlot.HEAD).setRegistryName("infinity_helmet"),
//                infinity_chestplate = new ArmorInfinityItem(EquipmentSlot.CHEST).setRegistryName("infinity_chestplate"),
//                infinity_pants = new ArmorInfinityItem(EquipmentSlot.LEGS).setRegistryName("infinity_pants"),
//                infinity_boots = new ArmorInfinityItem(EquipmentSlot.FEET).setRegistryName("infinity_boots"),
//
//
//                endest_pearl = new EndestPearlItem(),
//
//                star_fuel = new StarFuelItem(Rarity.EPIC, "star_fuel"),
//                ultimate_stew = new Item(new Item.Properties().tab(ModTab.TAB).rarity(Rarity.EPIC).food(ModFoods.ultimate_stew)).setRegistryName("ultimate_stew"),
//                cosmic_meatballs = new Item(new Item.Properties().tab(ModTab.TAB).rarity(Rarity.EPIC).food(ModFoods.cosmic_meatballs)).setRegistryName("cosmic_meatballs"),
//
//                diamond_lattice = new ResourceItem(Rarity.UNCOMMON, "diamond_lattice", false),
//                crystal_matrix_ingot = new ResourceItem(Rarity.RARE, "crystal_matrix_ingot", true),
//
//                neutron_pile = new ResourceItem(Rarity.UNCOMMON, "neutron_pile", true),
//                neutron_nugget = new ResourceItem(Rarity.UNCOMMON, "neutron_nugget", true),
//                neutronium_ingot = new ResourceItem(Rarity.RARE, "neutronium_ingot", true),
//                neutronium_gear = new ResourceItem(Rarity.EPIC, "neutronium_gear", true),
//
//                infinity_nugget = new ResourceItem(Rarity.RARE, "infinity_nugget", true),
//                infinity_catalyst = new ResourceItem(Rarity.EPIC, "infinity_catalyst", true),
//                infinity_ingot = new ResourceItem(COSMIC_RARITY, "infinity_ingot", true),
//
//                record_fragment = new ResourceItem(COSMIC_RARITY, "record_fragment", true),
//                singularity = new SingularityItem(p -> p.tab(ModTab.TAB)).setRegistryName("singularity")
//        );
//
//
//    }


}
