package dev.frankheijden.minecraftreflection.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReflectionCacheTree<T> {

    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

    private T value;
    private final Map<Class<?>, ReflectionCacheTree<T>> children = new HashMap<>();

    public ReflectionCacheTree(T value) {
        this.value = value;
    }

    public ReflectionCacheTree<T> find(Class<?>... parameters) {
        return findRecursive(parameters, 0);
    }

    private ReflectionCacheTree<T> findRecursive(Class<?>[] parameters, int i) {
        if (i >= parameters.length) return this;
        return children.computeIfAbsent(parameters[i], k -> new ReflectionCacheTree<>(null)).findRecursive(parameters, i + 1);
    }

    public T computeIfAbsent(Class<?>[] parameters, Function<Class<?>[], ? extends T> mappingFunction) {
        ReflectionCacheTree<T> tree = find(parameters);
        if (tree.value == null) tree.value = mappingFunction.apply(parameters);
        return tree.value;
    }

    public T computeIfAbsent(Supplier<? extends T> supplierFunction) {
        if (this.value == null) this.value = supplierFunction.get();
        return this.value;
    }
}
