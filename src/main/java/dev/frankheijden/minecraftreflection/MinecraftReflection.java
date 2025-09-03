package dev.frankheijden.minecraftreflection;

import dev.frankheijden.minecraftreflection.cache.ReflectionCache;

public class MinecraftReflection extends Reflection {

    protected MinecraftReflection(MinecraftReflection reflection) {
        super(reflection);
    }

    private MinecraftReflection(Class<?> clazz) {
        super(clazz);
    }

    public static String getClassName(String className) {
        if (className.contains("%s")) {
            return MinecraftReflectionVersion.NMS.isEmpty() ?
                    className.replace(".%s", "") : String.format(className, MinecraftReflectionVersion.NMS);
        }
        return className;
    }

    public static MinecraftReflection of(String className) {
        return of(Reflection.getClassFromName(getClassName(className)));
    }

    public static MinecraftReflection of(Class<?> clazz) {
        return ReflectionCache.getCachedReflections().computeIfAbsent(clazz, MinecraftReflection::new);
    }
}
