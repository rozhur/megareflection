package dev.frankheijden.minecraftreflection.cache;

import dev.frankheijden.minecraftreflection.MinecraftReflection;

import java.util.HashMap;
import java.util.Map;

public class ReflectionCache {

    private static final Map<Class<?>, MinecraftReflection> cachedReflections = new HashMap<>();

    public static Map<Class<?>, MinecraftReflection> getCachedReflections() {
        return cachedReflections;
    }
}
