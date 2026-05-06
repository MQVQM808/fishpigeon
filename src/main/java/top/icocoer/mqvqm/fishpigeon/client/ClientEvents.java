package top.icocoer.mqvqm.fishpigeon.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;
import top.icocoer.mqvqm.fishpigeon.registry.ModEntityTypes;

/**
 * 客户端模组事件统一入口：注册实体渲染器、模型层等。
 */
@EventBusSubscriber(modid = Fishpigeon.MODID, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {}

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
    }
}
