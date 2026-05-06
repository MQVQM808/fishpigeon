package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 数据组件注册类。
 */
public final class ModDataComponents {

    /** 数据组件延迟注册器。 */
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Fishpigeon.MODID);

    private ModDataComponents() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }

    /** 仅用于保留泛型引用，避免被误删。 */
    @SuppressWarnings("unused")
    private static <T> DataComponentType<T> _typeRef() { return null; }
}
