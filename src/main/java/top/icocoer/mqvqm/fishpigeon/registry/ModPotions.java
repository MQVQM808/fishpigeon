package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 药水注册类。
 */
public final class ModPotions {

    /** 药水延迟注册器。 */
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(Registries.POTION, Fishpigeon.MODID);

    private ModPotions() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        POTIONS.register(modEventBus);
    }
}
