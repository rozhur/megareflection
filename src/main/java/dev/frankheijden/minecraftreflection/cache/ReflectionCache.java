package dev.frankheijden.minecraftreflection.cache;

import dev.frankheijden.minecraftreflection.MinecraftReflection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionCache {

    private static final Map<Class<?>, MinecraftReflection> cachedReflections = new ConcurrentHashMap<>();

    public static Map<Class<?>, MinecraftReflection> getCachedReflections() {
        return cachedReflections;
    }
}
