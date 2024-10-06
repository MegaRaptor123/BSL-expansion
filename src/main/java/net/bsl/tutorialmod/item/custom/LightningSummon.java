package net.bsl.tutorialmod.item.custom;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class LightningSummon extends Item {
    public LightningSummon(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos(); // Get clicked block position
            Player player = pContext.getPlayer(); // Get the level (world) reference
            Level level = pContext.getLevel(); // Get the player




            player.getCooldowns().addCooldown(this, 40); //the cool down

            // Create a new lightning bolt entity
            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            if (pContext.getLevel().isThundering()){
                lightning.setDamage(10);
            }
            lightning.moveTo(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ());

            // Spawn the lightning bolt in the world
            level.addFreshEntity(lightning);
            // pContext.getLevel().getBlockState(positionClicked);
            BlockState blockState = level.getBlockState(positionClicked);
            if (blockState.is(Blocks.GRASS_BLOCK)){
                level.setBlockAndUpdate(positionClicked, Blocks.NETHERRACK.defaultBlockState());
            }
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                    p -> player.broadcastBreakEvent(player.getUsedItemHand()));

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}