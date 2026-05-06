package top.icocoer.mqvqm.fishpigeon.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 测试命令注册与处理。
 */
public final class ModCommands {

    private static final int TARGET_Y = 64;

    private ModCommands() {}

    /**
     * 注册 /fishpigeon dimension ... 子命令。
     */
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(
                Commands.literal("fishpigeon")
                        .then(Commands.literal("dimension")
                                .then(Commands.literal("pigeon")
                                        .executes(ctx -> teleportToDimension(ctx.getSource(), "pigeon_sekai")))
                                .then(Commands.literal("fish")
                                        .executes(ctx -> teleportToDimension(ctx.getSource(), "fish_warudo")))));
    }

    private static int teleportToDimension(CommandSourceStack source, String dimensionId) {
        if (!(source.getEntity() instanceof ServerPlayer player)) {
            source.sendFailure(Component.literal("Only players can use this command."));
            return 0;
        }

        ResourceKey<Level> targetKey = ResourceKey.create(
                net.minecraft.core.registries.Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath(Fishpigeon.MODID, dimensionId));

        ServerLevel targetLevel = source.getServer().getLevel(targetKey);
        if (targetLevel == null) {
            source.sendFailure(Component.literal("Dimension not found: " + Fishpigeon.MODID + ":" + dimensionId));
            return 0;
        }

        int targetX = Mth.floor(player.getX());
        int targetZ = Mth.floor(player.getZ());
        int targetY = findNearestYFrom64(targetLevel, targetX, targetZ);

        player.teleportTo(targetLevel, targetX + 0.5D, targetY, targetZ + 0.5D, player.getYRot(), player.getXRot());

        source.sendSuccess(
                () -> Component.literal("Teleported to " + Fishpigeon.MODID + ":" + dimensionId
                        + " at x=" + targetX + ", y=" + targetY + ", z=" + targetZ),
                false);
        return Command.SINGLE_SUCCESS;
    }

    /**
     * 以 y=64 为中心，寻找最近可站立位置。
     */
    private static int findNearestYFrom64(ServerLevel level, int x, int z) {
        int minY = level.getMinBuildHeight();
        int maxY = level.getMaxBuildHeight() - 2;
        int center = Mth.clamp(TARGET_Y, minY + 1, maxY);
        int maxRadius = Math.max(center - (minY + 1), maxY - center);

        for (int r = 0; r <= maxRadius; r++) {
            int up = center + r;
            if (up <= maxY && canStandAt(level, x, up, z)) {
                return up;
            }

            int down = center - r;
            if (down >= minY + 1 && canStandAt(level, x, down, z)) {
                return down;
            }
        }

        int fallbackY = Mth.clamp(level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), minY + 1, maxY);
        return fallbackY;
    }

    private static boolean canStandAt(ServerLevel level, int x, int y, int z) {
        BlockPos feetPos = new BlockPos(x, y, z);
        BlockPos headPos = feetPos.above();
        BlockPos groundPos = feetPos.below();

        BlockState ground = level.getBlockState(groundPos);
        BlockState feet = level.getBlockState(feetPos);
        BlockState head = level.getBlockState(headPos);

        boolean solidGround = ground.blocksMotion() && !ground.getCollisionShape(level, groundPos).isEmpty();
        boolean feetFree = !feet.blocksMotion();
        boolean headFree = !head.blocksMotion();

        return solidGround && feetFree && headFree;
    }
}
