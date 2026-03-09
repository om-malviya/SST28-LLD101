package com.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        Objects.requireNonNull(shape, "shape");
        Objects.requireNonNull(color, "color");
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        MarkerStyle existing = cache.get(key);
        if (existing != null) return existing;
        MarkerStyle created = new MarkerStyle(shape, color, size, filled);
        cache.put(key, created);
        return created;
    }

    public int cacheSize() {
        return cache.size();
    }
}