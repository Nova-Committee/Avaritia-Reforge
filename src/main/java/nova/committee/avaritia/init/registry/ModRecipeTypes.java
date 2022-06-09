package nova.committee.avaritia.init.registry;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nova.committee.avaritia.Static;
import nova.committee.avaritia.common.recipe.*;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 9:19
 * Version: 1.0
 */
@Mod.EventBusSubscriber(modid = Static.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipeTypes {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Static.MOD_ID);

    public static RegistryObject<RecipeSerializer<ShapedExtremeCraftingRecipe>> SHAPED_EXTREME_CRAFT_RECIPE = RECIPE_SERIALIZER.register("shaped_extreme_craft", ShapedExtremeCraftingRecipe.Serializer::new);

    public static RegistryObject<RecipeSerializer<ShapelessExtremeCraftingRecipe>> SHAPELESS_EXTREME_CRAFT_RECIPE = RECIPE_SERIALIZER.register("shapeless_extreme_craft", ShapelessExtremeCraftingRecipe.Serializer::new);

    public static RegistryObject<RecipeSerializer<CompressorRecipe>> COMPRESSOR_RECIPE = RECIPE_SERIALIZER.register("compressor", CompressorRecipe.Serializer::new);


    public static void init() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        RECIPE_SERIALIZER.register(bus);
    }

//    @SubscribeEvent
//    public static void registerRecipes(RegistryEvent.Register<RecipeSerializer<?>> event) {
//        final IForgeRegistry<RecipeSerializer<?>> registry = event.getRegistry();
//
//        registry.registerAll(
//                SHAPED_EXTREME_CRAFT_RECIPE.setRegistryName(new ResourceLocation(Static.MOD_ID, "shaped_extreme_craft")),
//                SHAPELESS_EXTREME_CRAFT_RECIPE.setRegistryName(new ResourceLocation(Static.MOD_ID, "shapeless_extreme_craft")),
//                COMPRESSOR_RECIPE.setRegistryName(new ResourceLocation(Static.MOD_ID, "compressor"))
//        );
//
//    }

    public static class RecipeTypes {
        public static final RecipeType<ICraftRecipe> CRAFTING = new RecipeType<ICraftRecipe>() {
//            @Override
//            public <C extends Container> Optional<ICraftRecipe> tryMatch(Recipe<C> recipe, Level world, C inv) {
//                return recipe.matches(inv, world) ? Optional.of((ICraftRecipe) recipe) : Optional.empty();
//            }
        };

        public static final RecipeType<ICompressorRecipe> COMPRESSOR = new RecipeType<ICompressorRecipe>() {

//            @Override
//            public <C extends Container> Optional<ICompressorRecipe> tryMatch(Recipe<C> recipe, Level world, C inv) {
//                return recipe.matches(inv, world) ? Optional.of((ICompressorRecipe) recipe) : Optional.empty();
//            }
        };
    }
}
