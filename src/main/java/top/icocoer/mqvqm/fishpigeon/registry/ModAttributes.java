package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 实体属性注册类。
 */
public final class ModAttributes {

    /** 属性延迟注册器。 */
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, Fishpigeon.MODID);

    private ModAttributes() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
    }
}
