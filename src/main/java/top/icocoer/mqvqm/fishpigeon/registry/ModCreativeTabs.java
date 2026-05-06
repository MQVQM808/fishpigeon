package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 创造模式物品栏（CreativeModeTab）的通用延迟注册类。
 */
public final class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fishpigeon.MODID);

    // ====== 主物品栏 ======
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB =
            CREATIVE_MODE_TABS.register("fishpigeon", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.fishpigeon.main"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.MINCED_PIGEON_FISH_MAW_SOUP.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MINCED_PIGEON_FISH_MAW_SOUP.get());
                    })
                    .build());

    private ModCreativeTabs() {}

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
