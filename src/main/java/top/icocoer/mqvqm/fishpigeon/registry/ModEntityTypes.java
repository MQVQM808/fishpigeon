package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 实体类型注册类。
 */
public final class ModEntityTypes {

    /** 实体类型延迟注册器。 */
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Fishpigeon.MODID);

    private ModEntityTypes() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
