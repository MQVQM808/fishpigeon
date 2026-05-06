package top.icocoer.mqvqm.fishpigeon;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import top.icocoer.mqvqm.fishpigeon.command.ModCommands;
import top.icocoer.mqvqm.fishpigeon.registry.ModRegistries;

/**
 * 模组主入口类。
 */
@Mod(Fishpigeon.MODID)
public class Fishpigeon {
    /** 模组 ID，需要与 neoforge.mods.toml 保持一致。 */
    public static final String MODID = "fishpigeon";
    /** 通用日志对象。 */
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * 构造函数在模组加载时调用，用于完成各类注册。
     */

    public Fishpigeon(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ModRegistries.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.addListener(ModCommands::onRegisterCommands);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    /** 通用初始化阶段。 */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    /** 服务端启动事件。 */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    /** 客户端事件监听。 */
    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        /** 客户端初始化事件。 */
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
