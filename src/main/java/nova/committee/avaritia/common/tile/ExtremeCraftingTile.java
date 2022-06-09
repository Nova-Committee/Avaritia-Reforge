package nova.committee.avaritia.common.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import nova.committee.avaritia.api.common.tile.BaseInventoryTileEntity;
import nova.committee.avaritia.common.menu.ExtremeCraftingMenu;
import nova.committee.avaritia.init.registry.ModTileEntities;
import nova.committee.avaritia.util.item.BaseItemStackHandler;
import nova.committee.avaritia.util.lang.Localizable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 8:44
 * Version: 1.0
 */
public class ExtremeCraftingTile extends BaseInventoryTileEntity implements MenuProvider {

    private final BaseItemStackHandler inventory;


    public ExtremeCraftingTile(BlockPos p_155229_, BlockState p_155230_) {
        super(ModTileEntities.extreme_crafting_tile.get(), p_155229_, p_155230_);
        this.inventory = createInventoryHandler(this::markDirtyAndDispatch);

    }

    public static BaseItemStackHandler createInventoryHandler(Runnable onContentsChanged) {
        return new BaseItemStackHandler(81, onContentsChanged);
    }

    @Override
    public @NotNull BaseItemStackHandler getInventory() {
        return inventory;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Localizable.of("container.extreme_crafting_table").build();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int p_createMenu_1_, @NotNull Inventory p_createMenu_2_, @NotNull Player p_createMenu_3_) {
        return ExtremeCraftingMenu.create(p_createMenu_1_, p_createMenu_2_, this::isUsableByPlayer, this.inventory);
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
        return !this.remove && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? LazyOptional.empty() : super.getCapability(cap, side);
    }


}
