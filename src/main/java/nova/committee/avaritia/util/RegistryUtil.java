package nova.committee.avaritia.util;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class RegistryUtil {

//    @SuppressWarnings("unchecked")
//    public static <T extends BlockEntity> BlockEntityType<T> build(BlockEntityType.BlockEntitySupplier<T> factory, String registryName, Block... block) {
//        //noinspection ConstantConditions
//        return (BlockEntityType<T>) BlockEntityType.Builder.of(factory, block).build(null).setRegistryName(registryName);
//    }


//    @SuppressWarnings("unchecked")
//    public static <T extends BlockEntity> BlockEntityType<T> build(BlockEntityType.BlockEntitySupplier<T> factory, ResourceLocation registryName, Block... block) {
//        //noinspection ConstantConditions
//        return (BlockEntityType<T>) BlockEntityType.Builder.of(factory, block).build(null).setRegistryName(registryName);
//    }

//    public static Item blockItem(Block block, Rarity rarity) {
//        return blockItem(block, new Item.Properties().rarity(rarity).tab(ModTab.TAB));
//    }
//
//    public static Item blockItem(Block block) {
//        return blockItem(block, new Item.Properties().tab(ModTab.TAB));
//    }
//
//    private static Item blockItem(Block block, Item.Properties properties) {
//        return new BlockItem(block, properties).setRegistryName(Objects.requireNonNull(block.getRegistryName()));
//    }


//    @SuppressWarnings("unchecked")
//    public static <T extends AbstractContainerMenu> MenuType<T> registerContainer(String name, IContainerFactory<T> containerFactory) {
//        return (MenuType<T>) new MenuType<>(containerFactory).setRegistryName(name);
//    }

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerRecipe(String p_44099_, S p_44100_) {
        return Registry.register(Registry.RECIPE_SERIALIZER, p_44099_, p_44100_);
    }
}
