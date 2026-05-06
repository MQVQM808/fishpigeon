package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
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

    /** 示例方块。 */
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock(
            "example_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
    );

    /** 示例方块对应的方块物品。 */
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    private ModBlocks() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
