package dev.frankheijden.minecraftreflection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReflectionTest extends BasicReflectionTest {

    static Stream<Arguments> getGenerator() {
        return Stream.of(
                of(10, new Reflection(Integer.class).<Integer>get(10, "value")),
                of(1.5f, new Reflection(Float.class).<Float>get(1.5f, "value")),
                of(1.5, new Reflection(Double.class).<Double>get(1.5, "value"))
        );
    }

    @ParameterizedTest
    @MethodSource("getGenerator")
    <T> void testGet(T expected, T actual) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> setGenerator() {
        return Stream.of(
                of(10, new Reflection(Integer.class), new Integer(0), "value", 10),
                of(1.5F, new Reflection(Float.class), new Float(0), "value", 1.5F),
                of(2.5D, new Reflection(Double.class), new Double(0), "value", 2.5D)
        );
    }

    @ParameterizedTest
    @MethodSource("setGenerator")
    <T> void testSet(T expected, Reflection reflection, Object instance, String field, T updateValue) {
        reflection.set(instance, field, updateValue);
        assertEquals(expected, reflection.get(instance, field));
    }

    @Test
    void invoke() {
    }

    @Test
    void testInvoke() {
    }

    @Test
    void getTypes() {
    }

    @Test
    void getAccessibleField() {
    }

    @Test
    void getField() {
    }

    @Test
    void getAccessibleMethod() {
    }

    @Test
    void getMethod() {
    }
}
