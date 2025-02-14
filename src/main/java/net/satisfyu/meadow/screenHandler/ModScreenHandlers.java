package net.satisfyu.meadow.screenHandler;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.satisfyu.meadow.Meadow;
import net.satisfyu.meadow.block.cheeseForm.CheeseFormScreenHandler;
import net.satisfyu.meadow.block.cookingCauldron.CookingCauldronScreenHandler;
import net.satisfyu.meadow.block.cookingPot.CookingPotScreenHandler;
import net.satisfyu.meadow.block.fondueBlock.FondueScreenHandler;
import net.satisfyu.meadow.block.woodCutter.WoodcutterScreenHandler;

public class ModScreenHandlers {

    public static ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTOR_SCREEN_HANDLER;
    public static ScreenHandlerType<CookingCauldronScreenHandler> COOKING_CAULDRON_SCREEN_HANDLER;

    public static ScreenHandlerType<CheeseFormScreenHandler> CHEESE_FORM_SCREEN_HANDLER;
    public static ScreenHandlerType<FondueScreenHandler> FONDUE_SCREEN_HANDLER;

    public static ScreenHandlerType<CookingPotScreenHandler> COOKING_POT_SCREEN_HANDLER;

    public static void registerScreenHandler(){
        CHEESE_FORM_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Meadow.MOD_ID, "cheese_form"), new ScreenHandlerType<>(CheeseFormScreenHandler::new));
        WOODCUTTOR_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Meadow.MOD_ID, "woodcutter"), new ScreenHandlerType<>(WoodcutterScreenHandler::new));
        COOKING_CAULDRON_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Meadow.MOD_ID, "cooking_cauldron"), new ScreenHandlerType<>(CookingCauldronScreenHandler::new));
        FONDUE_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Meadow.MOD_ID, "fondue"), new ScreenHandlerType<>(FondueScreenHandler::new));

        COOKING_POT_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Meadow.MOD_ID, "cooking_pot"), new ScreenHandlerType<>(CookingPotScreenHandler::new));
    }


}
