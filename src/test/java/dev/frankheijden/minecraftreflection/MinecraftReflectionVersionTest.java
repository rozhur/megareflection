package dev.frankheijden.minecraftreflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinecraftReflectionVersionTest  extends BasicReflectionTest {

    @Test
    void testNMS() {
        assertEquals("v1_16_R3", MinecraftReflectionVersion.NMS);
    }

    @Test
    void testMajor() {
        assertEquals(1, MinecraftReflectionVersion.MAJOR);
    }

    @Test
    void testMinor() {
        assertEquals(16, MinecraftReflectionVersion.MINOR);
    }

    @Test
    void testPatch() {
        assertEquals(3, MinecraftReflectionVersion.PATCH);
    }
}