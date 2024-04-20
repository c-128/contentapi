package com.c64.contentapi.api;

import net.kyori.adventure.key.Key;

import java.util.Collection;
import java.util.HashMap;

public class ContentRegistry<T> {

    private final HashMap<Key, Content<T>> entries;

    public ContentRegistry() {
        this.entries = new HashMap<>();
    }

    public void register(Key key, Content<T> value) {
        if (this.entries.containsKey(key)) {
            throw new RuntimeException("Key is already registered");
        }
        if (this.entries.containsValue(value)) {
            throw new RuntimeException("Value is already registered");
        }

        this.entries.put(key, value);
    }

    public boolean isRegistered(Key key) {
        return this.entries.containsKey(key);
    }

    public boolean isCustomContent(T value) {
        for (Content<T> entry : this.entries.values()) {
            if (entry.is(value)) {
                return true;
            }
        }

        return false;
    }

    public Content<T> get(Key key) {
        return this.entries.get(key);
    }

    public Collection<Key> keys() {
        return entries.keySet();
    }

    public Collection<Content<T>> values() {
        return entries.values();
    }
}
