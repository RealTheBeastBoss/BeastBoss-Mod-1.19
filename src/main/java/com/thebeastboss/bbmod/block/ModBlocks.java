package com.thebeastboss.bbmod.block;

import com.thebeastboss.bbmod.BeastBossMod;
import com.thebeastboss.bbmod.item.ModCreativeModTab;
import com.thebeastboss.bbmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BeastBossMod.MOD_ID);

    public static final RegistryObject<Block> BEASTBOSSANIUM_BLOCK = registerBlock("beastbossanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.BEASTBOSS_TAB);
    public static final RegistryObject<Block> BEASTBOSSANIUM_ORE = registerBlock("beastbossanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModTab.BEASTBOSS_TAB);
    public static final RegistryObject<Block> DEEPSLATE_BEASTBOSSANIUM_ORE = registerBlock("deepslate_beastbossanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModTab.BEASTBOSS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void resister(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
