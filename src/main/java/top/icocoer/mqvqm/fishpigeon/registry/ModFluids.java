package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 流体与流体类型注册类。
 */
public final class ModFluids {

    /** 原版流体延迟注册器。 */
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Fishpigeon.MODID);

    /** NeoForge 流体类型延迟注册器。 */
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Fishpigeon.MODID);

    private ModFluids() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        FLUIDS.register(modEventBus);
        FLUID_TYPES.register(modEventBus);
    }
}
