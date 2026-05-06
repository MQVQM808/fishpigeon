package top.icocoer.mqvqm.fishpigeon.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;
import top.icocoer.mqvqm.fishpigeon.registry.ModEntityTypes;

/**
 * 监听模组事件总线，集中为本模组实体注册属性 {@link net.minecraft.world.entity.ai.attributes.AttributeSupplier}。
 */
@EventBusSubscriber(modid = Fishpigeon.MODID)
public final class ModEntityAttributes {

    private ModEntityAttributes() {}

    @SubscribeEvent
    public static void onCreateAttributes(EntityAttributeCreationEvent event) {
    }
}
