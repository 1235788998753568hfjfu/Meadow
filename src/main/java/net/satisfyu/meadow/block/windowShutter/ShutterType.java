package net.satisfyu.meadow.block.windowShutter;

import net.minecraft.util.StringIdentifiable;

public enum ShutterType implements StringIdentifiable {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom"),
    NONE("none");

    private final String name;

    private ShutterType(String type) {
        this.name = type;
    }

    @Override
    public String asString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}

