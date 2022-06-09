package nova.committee.avaritia.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import nova.committee.avaritia.common.recipe.ShapelessExtremeCraftingRecipe;
import nova.committee.avaritia.init.handler.DynamicRecipeHandler;
import nova.committee.avaritia.init.handler.SingularityRegistryHandler;
import nova.committee.avaritia.init.registry.ModItems;
import nova.committee.avaritia.util.SingularityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/5/16 23:12
 * Version: 1.0
 */
public class ModRecipes {
    public static ShapelessExtremeCraftingRecipe infinityCatalyst; //催化剂

    public static void addExtremeCrafts() {
        List<ItemStack> singularityList = new ArrayList<>();
        for (var singularity : SingularityRegistryHandler.getInstance().getSingularities()) {
            var itemStack = SingularityUtils.getItemForSingularity(singularity);

            singularityList.add(itemStack);
        }

        singularityList.add(new ItemStack(Blocks.EMERALD_BLOCK));
        singularityList.add(new ItemStack(ModItems.crystal_matrix_ingot.get()));
        singularityList.add(new ItemStack(ModItems.neutronium_ingot.get()));
        singularityList.add(new ItemStack(ModItems.cosmic_meatballs.get()));
        singularityList.add(new ItemStack(ModItems.ultimate_stew.get()));
        singularityList.add(new ItemStack(ModItems.endest_pearl.get()));
        singularityList.add(new ItemStack(ModItems.record_fragment.get()));

        infinityCatalyst = DynamicRecipeHandler.addExtremeShapelessRecipe(
                new ItemStack(ModItems.infinity_catalyst.get()), singularityList);


    }
}
