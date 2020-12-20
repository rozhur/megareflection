package dev.frankheijden.minecraftreflection;

public class ClassObject<T> {

    private final Class<?> clazz;
    private final T object;

    private ClassObject(Class<?> clazz, T object) {
        this.clazz = clazz;
        this.object = object;
    }

    public static <T> ClassObject<T> of(Class<?> clazz, T object) {
        return new ClassObject<>(clazz, object);
    }

    public static <T> ClassObject<T> of(T object) {
        return new ClassObject<>(object.getClass(), object);
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public T getObject() {
        return object;
    }

    public static Class<?>[] getTypes(ClassObject<?>... objects) {
        Class<?>[] types = new Class[objects.length];
        for (int i = 0; i < objects.length; i++) {
            types[i] = objects[i].getClazz();
        }
        return types;
    }

    public static Object[] getObjects(ClassObject<?>... objects) {
        Object[] types = new Object[objects.length];
        for (int i = 0; i < objects.length; i++) {
            types[i] = objects[i].getObject();
        }
        return types;
    }
}
