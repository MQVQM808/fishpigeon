package top.icocoer.mqvqm.fishpigeon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.icocoer.mqvqm.fishpigeon.Fishpigeon;

/**
 * 配方类型与序列化器注册类。
 */
public final class ModRecipes {

    /** 配方类型延迟注册器。 */
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Fishpigeon.MODID);

    /** 配方序列化器延迟注册器。 */
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Fishpigeon.MODID);

    private ModRecipes() {}

    /** 挂载到模组事件总线。 */
    @SuppressWarnings("null")
    public static void register(IEventBus modEventBus) {
        RECIPE_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
