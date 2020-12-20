package dev.frankheijden.minecraftreflection.utils;

public class ReflectionStringUtils {

    public static String constructor(Class<?> clazz, Class<?>... parameterTypes) {
        return "new " + clazz.getName() + "(" + parameters(parameterTypes) + ")";
    }

    public static String field(Class<?> clazz, String field) {
        return clazz.getName() + "#" + field;
    }

    public static String method(Class<?> clazz, String method, Class<?>... parameterTypes) {
        return clazz.getName() + "#" + method + "(" + parameters(parameterTypes) + ")";
    }

    private static String parameters(Class<?>... parameterTypes) {
        StringBuilder parameterBuilder = new StringBuilder();
        for (Class<?> type : parameterTypes) {
            parameterBuilder.append(", ").append(clazz(type));
        }
        return parameterBuilder.length() > 2 ? parameterBuilder.substring(2) : parameterBuilder.toString();
    }

    public static String clazz(Class<?> clazz) {
        return clazz.isArray() ? clazz.getComponentType().getName() + "[]" : clazz.getName();
    }
}
