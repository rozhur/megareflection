package dev.frankheijden.minecraftreflection;

import org.bukkit.Bukkit;

public class MinecraftReflectionVersion {

    public static final String NMS;
    public static final int MAJOR;
    public static final int MINOR;
    public static final int PATCH;

    static {
        String bukkitPackage = Bukkit.getServer().getClass().getPackage().getName();
        NMS = bukkitPackage.substring(bukkitPackage.lastIndexOf('.') + 1);

        String[] split = NMS.split("_");
        MAJOR = Integer.parseInt(split[0].substring(1));
        MINOR = Integer.parseInt(split[1]);
        PATCH = Integer.parseInt(split[2].substring(1, 2));
    }

    public static boolean is(int minor) {
        return MINOR == minor;
    }

    public static boolean is(int minor, int patch) {
        return MINOR == minor && PATCH == patch;
    }

    public static boolean isMin(int minor) {
        return MINOR >= minor;
    }

    public static boolean isMin(int minor, int patch) {
        return MINOR > minor || (MINOR == minor && PATCH >= patch);
    }

    public static boolean isMax(int minor) {
        return MINOR <= minor;
    }

    public static boolean isMax(int minor, int patch) {
        return MINOR < minor || (MINOR == minor && PATCH <= patch);
    }
}
