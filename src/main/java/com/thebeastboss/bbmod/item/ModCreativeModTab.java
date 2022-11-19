package com.thebeastboss.bbmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab BEASTBOSS_TAB = new CreativeModeTab("bbtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BEASTBOSS_COIN.get());
        }
    };
}
