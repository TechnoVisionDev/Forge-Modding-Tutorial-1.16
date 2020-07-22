package com.technovision.tutorial.objects.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, 1, 2, 14, 9, 14), Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 13), Block.makeCuboidShape(13, 2, 1, 16, 3, 2),
            Block.makeCuboidShape(15, 0, 1, 16, 2, 2), Block.makeCuboidShape(13, 2, 14, 16, 3, 15),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15), Block.makeCuboidShape(0, 2, 14, 3, 3, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15), Block.makeCuboidShape(0, 2, 1, 3, 3, 2),
            Block.makeCuboidShape(0, 0, 1, 1, 2, 2), Block.makeCuboidShape(6, 11, 12, 10, 16, 13),
            Block.makeCuboidShape(6, 3, 14, 10, 16, 15), Block.makeCuboidShape(6, 10, 13, 10, 16, 14),
            Block.makeCuboidShape(6, 12, 15, 10, 16, 16)).reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2, 1, 2, 14, 9, 14), Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 13), Block.makeCuboidShape(14, 2, 13, 15, 3, 16),
            Block.makeCuboidShape(14, 0, 15, 15, 2, 16), Block.makeCuboidShape(1, 2, 13, 2, 3, 16),
            Block.makeCuboidShape(1, 0, 15, 2, 2, 16), Block.makeCuboidShape(1, 2, 0, 2, 3, 3),
            Block.makeCuboidShape(1, 0, 0, 2, 2, 1), Block.makeCuboidShape(14, 2, 0, 15, 3, 3),
            Block.makeCuboidShape(14, 0, 0, 15, 2, 1), Block.makeCuboidShape(3, 11, 6, 4, 16, 10),
            Block.makeCuboidShape(1, 3, 6, 2, 16, 10), Block.makeCuboidShape(2, 10, 6, 3, 16, 10),
            Block.makeCuboidShape(0, 12, 6, 1, 16, 10)).reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(2, 1, 2, 14, 9, 14), Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 13), Block.makeCuboidShape(0, 2, 14, 3, 3, 15),
            Block.makeCuboidShape(0, 0, 14, 1, 2, 15), Block.makeCuboidShape(0, 2, 1, 3, 3, 2),
            Block.makeCuboidShape(0, 0, 1, 1, 2, 2), Block.makeCuboidShape(13, 2, 1, 16, 3, 2),
            Block.makeCuboidShape(15, 0, 1, 16, 2, 2), Block.makeCuboidShape(13, 2, 14, 16, 3, 15),
            Block.makeCuboidShape(15, 0, 14, 16, 2, 15), Block.makeCuboidShape(6, 11, 3, 10, 16, 4),
            Block.makeCuboidShape(6, 3, 1, 10, 16, 2), Block.makeCuboidShape(6, 10, 2, 10, 16, 3),
            Block.makeCuboidShape(6, 12, 0, 10, 16, 1)).reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 1, 2, 14, 9, 14), Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(3, 10, 3, 13, 11, 13), Block.makeCuboidShape(1, 2, 0, 2, 3, 3),
            Block.makeCuboidShape(1, 0, 0, 2, 2, 1), Block.makeCuboidShape(14, 2, 0, 15, 3, 3),
            Block.makeCuboidShape(14, 0, 0, 15, 2, 1), Block.makeCuboidShape(14, 2, 13, 15, 3, 16),
            Block.makeCuboidShape(14, 0, 15, 15, 2, 16), Block.makeCuboidShape(1, 2, 13, 2, 3, 16),
            Block.makeCuboidShape(1, 0, 15, 2, 2, 16), Block.makeCuboidShape(12, 11, 6, 13, 16, 10),
            Block.makeCuboidShape(14, 3, 6, 15, 16, 10), Block.makeCuboidShape(13, 10, 6, 14, 16, 10),
            Block.makeCuboidShape(15, 12, 6, 16, 16, 10)).reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5F, 4.0F)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**Change the block shadow -- Lower return values = more shadow*/
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}
