package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 方块注册类。
 */
public final class ModBlocks {

    /** 方块延迟注册器。 */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Fishpigeon.MODID);

        /** 鸽石，作为鸽子世界的主体岩层。 */
        public static final DeferredBlock<Block> PIGEON_STONE = BLOCKS.registerSimpleBlock(
            "pigeon_stone",
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(1.5F, 6.0F)
                .requiresCorrectToolForDrops()
        );

        /** 鸽土，作为鸽子世界的表层土壤。 */
        public static final DeferredBlock<Block> PIGEON_DIRT = BLOCKS.registerSimpleBlock(
            "pigeon_dirt",
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.DIRT)
                .strength(0.5F)
        );

        /** 草鸽土，作为鸽子世界的地表草皮。 */
        public static final DeferredBlock<Block> GRASS_PIGEON_DIRT = BLOCKS.register(
            "grass_pigeon_dirt",
            () -> new GrassBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.GRASS)
                .strength(0.6F)
                .randomTicks())
        );

        public static final DeferredItem<BlockItem> PIGEON_STONE_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("pigeon_stone", PIGEON_STONE);

        public static final DeferredItem<BlockItem> PIGEON_DIRT_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("pigeon_dirt", PIGEON_DIRT);

        public static final DeferredItem<BlockItem> GRASS_PIGEON_DIRT_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("grass_pigeon_dirt", GRASS_PIGEON_DIRT);

    private ModBlocks() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
