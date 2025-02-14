package net.satisfyu.meadow.block;

import net.minecraft.state.property.EnumProperty;
import net.satisfyu.meadow.block.custom.LineConnectingType;
import net.satisfyu.meadow.block.windowShutter.ShutterType;

public class ModBlockProperties {
    public static final EnumProperty<ShutterType> SHUTTER_TYPE;
    public static final EnumProperty<LineConnectingType> LINE_CONNECTING_TYPE;

    static {
        SHUTTER_TYPE = EnumProperty.of("type", ShutterType.class);
        LINE_CONNECTING_TYPE = EnumProperty.of("type", LineConnectingType.class);
    }
}
