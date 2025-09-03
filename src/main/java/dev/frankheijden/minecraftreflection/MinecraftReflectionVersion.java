package dev.frankheijden.minecraftreflection;

import org.bukkit.Bukkit;

public class MinecraftReflectionVersion {

    public static final String NMS;
    public static final int MAJOR;
    public static final int MINOR;
    public static final int PATCH;

    static {
        String bukkitPackage = Bukkit.getServer().getClass().getPackage().getName();
        String nms = bukkitPackage.substring(bukkitPackage.lastIndexOf('.') + 1);

        if (nms.contains("_")) {
            NMS = nms;
        } else {
            NMS = "";
        }

        /*String[] split = NMS.split("_");
        MAJOR = Integer.parseInt(split[0].substring(1));
        MINOR = Integer.parseInt(split[1]);
        PATCH = Integer.parseInt(split[2].substring(1, 2));*/

        String version = Bukkit.getVersion();
        version = version.substring(version.indexOf("(MC: ") + 5, version.length() - 1);

        String[] versionParts = version.split("\\.");

        MAJOR = Integer.parseInt(versionParts[0]);
        MINOR = Integer.parseInt(versionParts[1]);
        PATCH = versionParts.length > 2 ? Integer.parseInt(versionParts[2]) : 0;
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
