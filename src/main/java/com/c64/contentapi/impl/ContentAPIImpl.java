package com.c64.contentapi.impl;

import com.c64.contentapi.api.ContentAPI;
import com.c64.contentapi.api.ContentRegistry;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

class ContentAPIImpl implements ContentAPI {

    private final ContentRegistry<ItemStack> itemRegistry;
    private final ContentRegistry<Block> blockRegistry;
    private final ContentRegistry<Entity> entityRegistry;

    ContentAPIImpl() {
        this.itemRegistry = new ContentRegistry<>();
        this.blockRegistry = new ContentRegistry<>();
        this.entityRegistry = new ContentRegistry<>();
    }

    @Override
    public ContentRegistry<ItemStack> getItemRegistry() {
        return this.itemRegistry;
    }

    @Override
    public ContentRegistry<Block> getBlockRegistry() {
        return this.blockRegistry;
    }

    @Override
    public ContentRegistry<Entity> getEntityRegistry() {
        return this.entityRegistry;
    }
}
