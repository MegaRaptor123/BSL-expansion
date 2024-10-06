package net.bsl.tutorialmod.item;

import net.bsl.tutorialmod.bslExp;
import net.bsl.tutorialmod.item.custom.LightningSummon;
import net.bsl.tutorialmod.item.custom.MetalDectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = // deferred register is a long list of a certain things, int his case it is items, when forge loads the items, then it will be loaded
            DeferredRegister.create(ForgeRegistries.ITEMS, bslExp.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff",
            () -> new LightningSummon(new Item.Properties().durability(100)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
