# ContentAPI
ContentAPI is a Paper plugin for fixing custom item conflicts.

## Installation
1. Add the ContentAPI [JitPack](https://jitpack.io/#c-128/contentapi) dependency:
```gradle
repositories {
    maven { url "https://jitpack.io"  }
}

dependencies {
    compileOnly "com.github.c-128:contentapi:version"
}
```
You can find the latest version in the releases tab.

2. Add the plugin as a dependency in your `paper-plugin.yaml`:
```yaml
dependencies:
  server:
    ContentAPI:
      load: 'BEFORE'
      required: true
      join-classpath: true
```

## Usage
```java
RegisteredServiceProvider<ContentAPI> serviceProvider = servicesManager.getRegistration(ContentAPI.class);
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

// You can also check if an ItemStack is a custom item, registered by another plugin.
// If so, you can deal with it accordingly.
ItemStack stack = new ItemStack(Material.AIR);
boolean isCustom = itemRegistry.isCustomContent(stack);
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
