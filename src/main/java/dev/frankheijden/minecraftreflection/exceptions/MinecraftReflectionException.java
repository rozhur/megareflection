package dev.frankheijden.minecraftreflection.exceptions;

public class MinecraftReflectionException extends RuntimeException {

    private static final long serialVersionUID = -7270949041140418100L;

    public MinecraftReflectionException() {
        super();
    }

    public MinecraftReflectionException(String message) {
        super(message);
    }

    public MinecraftReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinecraftReflectionException(Throwable cause) {
        super(cause);
    }

    protected MinecraftReflectionException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
