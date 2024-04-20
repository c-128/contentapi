package com.c64.contentapi.impl;

import com.c64.contentapi.api.ContentAPI;
import com.c64.contentapi.api.ContentRegistry;
import io.th0rgal.oraxen.api.OraxenBlocks;
import io.th0rgal.oraxen.api.OraxenItems;
import net.kyori.adventure.key.Key;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

class OraxenCompat {

    private static final String ORAXEN_PLUGIN_NAME = "Oraxen";

    public static void init(JavaPlugin plugin, ContentAPI api) {
        Server server = plugin.getServer();
        Logger logger = plugin.getLogger();
        PluginManager pluginMan = server.getPluginManager();

        if (!pluginMan.isPluginEnabled(ORAXEN_PLUGIN_NAME)) {
            return;
        }

        logger.info("Initializing Oraxen compatibility...");

        ContentRegistry<ItemStack> itemRegistry = api.getItemRegistry();
        ContentRegistry<Block> blockRegistry = api.getBlockRegistry();

        itemRegistry.register(Key.key("contentapi", "oraxen"), OraxenCompat::isOraxenItem);
        blockRegistry.register(Key.key("contentapi", "oraxen"), OraxenCompat::isOraxenBlock);
    }

    private static boolean isOraxenItem(ItemStack item) {
        String id = OraxenItems.getIdByItem(item);
        if (id == null) {
            return false;
        }

        return true;
    }

    private static boolean isOraxenBlock(Block block) {
        return OraxenBlocks.isOraxenBlock(block);
    }
}
