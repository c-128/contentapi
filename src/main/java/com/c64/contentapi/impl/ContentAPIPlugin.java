package com.c64.contentapi.impl;

import com.c64.contentapi.api.ContentAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ContentAPIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ContentAPI contentAPI = new ContentAPIImpl();
        ServicesManager servicesManager = Bukkit.getServicesManager();

        OraxenCompat.init(this, contentAPI);

        servicesManager.register(ContentAPI.class, contentAPI, this, ServicePriority.Normal);
    }

    @Override
    public void onDisable() {
    }
}
