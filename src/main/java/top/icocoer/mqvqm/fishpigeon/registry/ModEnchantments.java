package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 附魔（Enchantment）键的集中声明类。
 * <p>
 * 自 1.21 起，附魔本身改为<b>数据驱动</b>（通过 JSON 在 datapack 中定义），
 * 因此运行时不再使用 {@code DeferredRegister} 注册。这里仅集中保存附魔的
 * {@link ResourceKey}，便于代码侧引用，例如：
 * <pre>{@code
 * public static final ResourceKey<Enchantment> MY_ENCHANT = key("my_enchant");
 * }</pre>
 */
public final class ModEnchantments {

    private ModEnchantments() {}
    @SuppressWarnings("null")
    public static ResourceKey<Enchantment> key(String name) {
        return ResourceKey.create(
                net.minecraft.core.registries.Registries.ENCHANTMENT,
                ResourceLocation.fromNamespaceAndPath(Fishpigeon.MODID, name));
    }
}
