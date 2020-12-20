package dev.frankheijden.minecraftreflection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;

import dev.frankheijden.minecraftreflection.utils.ReflectionStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReflectionStringUtilsTest {

    static Stream<Arguments> stringGenerator() {
        return Stream.of(
                of("java.lang.String#field", ReflectionStringUtils.field(String.class, "field")),
                of("java.lang.Integer#value", ReflectionStringUtils.field(Integer.class, "value")),

                of("java.lang.Integer#compareTo(java.lang.Integer)", ReflectionStringUtils.method(Integer.class, "compareTo", Integer.class)),
                of("java.lang.Integer#a(java.lang.Integer, java.lang.String)", ReflectionStringUtils.method(Integer.class, "a", Integer.class, String.class))
        );
    }

    @ParameterizedTest
    @MethodSource("stringGenerator")
    void stringTest(String expected, String actual) {
        assertEquals(expected, actual);
    }
}