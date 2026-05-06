package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 物品注册类。
 */
public final class ModItems {

    /** 物品延迟注册器。 */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Fishpigeon.MODID);

    /** 食物：鸽茸鱼肚羹。 */
    public static final DeferredItem<Item> MINCED_PIGEON_FISH_MAW_SOUP = ITEMS.registerSimpleItem(
            "minced_pigeon_fish_maw_soup",
            new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(8)
                .saturationModifier(0.8f)
                    .build())
    );

    private ModItems() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
