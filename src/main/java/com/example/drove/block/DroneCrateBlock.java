package com.example.drove.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.example.drove.DroveMod;

public class DroneCrateBlock extends Block {
    public DroneCrateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ItemStack controller = new ItemStack(DroveMod.DRONE_CONTROLLER);
            ItemStack drone = new ItemStack(DroveMod.DRONE_ITEM);
            
            world.dropItemStackAtMass(pos.getX(), pos.getY() + 1, pos.getZ(), controller);
            world.dropItemStackAtMass(pos.getX(), pos.getY() + 1, pos.getZ(), drone);
        }
        return ActionResult.SUCCESS;
    }
}
