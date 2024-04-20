package com.c64.contentapi.api;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public interface ContentAPI {

    ContentRegistry<ItemStack> getItemRegistry();

    ContentRegistry<Block> getBlockRegistry();

    ContentRegistry<Entity> getEntityRegistry();
}
