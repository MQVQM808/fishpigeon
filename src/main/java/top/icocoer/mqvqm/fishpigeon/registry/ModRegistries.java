package top.icocoer.mqvqm.fishpigeon.registry;

import net.neoforged.bus.api.IEventBus;

/**
 * 所有注册类的统一入口。
 */
public final class ModRegistries {

    private ModRegistries() {}

    /**
     * 统一将各类 DeferredRegister 挂载到模组事件总线。
     */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModAttributes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModParticles.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModVillagers.register(modEventBus);
    }
}
