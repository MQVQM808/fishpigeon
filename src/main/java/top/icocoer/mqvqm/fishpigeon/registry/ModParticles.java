package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 粒子类型注册类。
 */
public final class ModParticles {

    /** 粒子类型延迟注册器。 */
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, Fishpigeon.MODID);

    private ModParticles() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        PARTICLE_TYPES.register(modEventBus);
    }
}
