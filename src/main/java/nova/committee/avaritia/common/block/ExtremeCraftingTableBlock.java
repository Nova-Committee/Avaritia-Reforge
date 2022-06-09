package nova.committee.avaritia.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import nova.committee.avaritia.api.common.block.BaseTileEntityBlock;
import nova.committee.avaritia.common.tile.ExtremeCraftingTile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 7:38
 * Version: 1.0
 */
public class ExtremeCraftingTableBlock extends BaseTileEntityBlock {

    public ExtremeCraftingTableBlock() {
        super(Material.METAL, SoundType.GLASS, 100f, 2000F, true);
        //setRegistryName("extreme_crafting_table");
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState p_60503_, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand p_60507_, @NotNull BlockHitResult p_60508_) {
        if (!level.isClientSide()) {
            var tile = level.getBlockEntity(pos);

            if (tile instanceof ExtremeCraftingTile table)
                player.openMenu(table);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            var tile = level.getBlockEntity(pos);

            if (tile instanceof ExtremeCraftingTile table) {
                Containers.dropContents(level, pos, table.getInventory().getStacks());
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ExtremeCraftingTile(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_49232_) {
        return RenderShape.MODEL;
    }
}
