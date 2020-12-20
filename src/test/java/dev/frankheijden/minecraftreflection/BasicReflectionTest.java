package dev.frankheijden.minecraftreflection;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BasicReflectionTest {

    Server server;
    MockedStatic<Bukkit> holder;

    @BeforeEach
    void setUp() {
        server = Mockito.mock(CraftServer.class);
        holder = Mockito.mockStatic(Bukkit.class);
        holder.when(Bukkit::getServer).thenReturn(server);
    }

    @AfterEach
    void cleanUp() {
        holder.close();
    }
}
