package com.c64.contentapi.example;

import com.c64.contentapi.api.ContentRegistry;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import com.c64.contentapi.api.ContentAPI;

public final class Example extends JavaPlugin {

    @Override
    public void onEnable() {
        RegisteredServiceProvider<ContentAPI> serviceProvider = Bukkit.getServicesManager().getRegistration(ContentAPI.class);
        if (serviceProvider == null) {
            // ContentAPI is not loaded
            return;
        }

        ContentAPI api = serviceProvider.getProvider();
        ContentRegistry<ItemStack> itemRegistry = api.getItemRegistry();

        // Register a custom item
        itemRegistry.register(Key.key("example", "example_item"), item -> {
            // Here you can check if the ItemStack is your custom item.
            // Here you can for example check for a NBT tag or similar metadata.
            ItemMeta meta = item.getItemMeta();
            if (meta == null) {
                return false;
            }

            if (meta.getCustomModelData() != 1) {
                return false;
            }

            return true;
        });

    }

    @Override
    public void onDisable() {
    }
}
