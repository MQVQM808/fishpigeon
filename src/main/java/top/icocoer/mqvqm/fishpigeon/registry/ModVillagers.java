package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 村民职业与村民类型注册类。
 */
public final class ModVillagers {

    /** 村民职业延迟注册器。 */
    public static final DeferredRegister<VillagerProfession> PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, Fishpigeon.MODID);

    /** 村民类型延迟注册器。 */
    public static final DeferredRegister<VillagerType> VILLAGER_TYPES =
            DeferredRegister.create(Registries.VILLAGER_TYPE, Fishpigeon.MODID);

    private ModVillagers() {}

    /** 挂载到模组事件总线。 */
    public static void register(IEventBus modEventBus) {
        PROFESSIONS.register(modEventBus);
        VILLAGER_TYPES.register(modEventBus);
    }
}
