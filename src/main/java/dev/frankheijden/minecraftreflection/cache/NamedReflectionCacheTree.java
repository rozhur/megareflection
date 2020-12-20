package dev.frankheijden.minecraftreflection.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class NamedReflectionCacheTree<T> {

    private final Map<String, ReflectionCacheTree<T>> treeMap = new HashMap<>();

    public T computeIfAbsent(String name, Class<?>[] parameters, Function<Class<?>[], ? extends T> mappingFunction) {
        return treeMap.computeIfAbsent(name, k -> new ReflectionCacheTree<>(null)).computeIfAbsent(parameters, mappingFunction);
    }

    public T computeIfAbsent(String name, Supplier<? extends T> supplierFunction) {
        return treeMap.computeIfAbsent(name, k -> new ReflectionCacheTree<>(null)).computeIfAbsent(supplierFunction);
    }
}
