package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 世界特性注册类。
 */
public final class ModFeatures {

    /** 世界特性延迟注册器。 */
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, Fishpigeon.MODID);

    private ModFeatures() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}
