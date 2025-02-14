package net.satisfyu.meadow.block.cheeseForm;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.satisfyu.meadow.Meadow;
import net.satisfyu.meadow.screenHandler.*;

public class CheeseFormScreen extends RecipeHandledScreen<CheeseFormScreenHandler> {
    private static final Identifier BACKGROUND;
    private static final Identifier SIDE_TIP;
    private static final int FRAMES = 2;

    public CheeseFormScreen(CheeseFormScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, BACKGROUND, SIDE_TIP, FRAMES);
        textRenderer = MinecraftClient.getInstance().textRenderer;
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    public void renderProgressArrow(MatrixStack matrices, int x, int y) {
        final int progressX = this.handler.getScaledXProgress();
        this.drawTexture(matrices, x + 79, y + 36, 178, 4, progressX, 10);
        final int progressY = this.handler.getScaledYProgress();
        this.drawTexture(matrices, x + 81, y + 8, 180, 22, 16, progressY);
    }

    @Override
    public void addToolTips() {
        super.addToolTips();
        addToolTip(new SideToolTip(54, 20, 34, 30, Text.translatable("tooltip.meadow.cheese_form.cheese_mass")));
        addToolTip(new SideToolTip(54, 111, 34, 30, Text.translatable("tooltip.meadow.cheese_form.cheese")));
    }

    static {
        BACKGROUND = new Identifier(Meadow.MOD_ID, "textures/gui/cheese_form_gui.png");
        SIDE_TIP = new Identifier(Meadow.MOD_ID, "textures/gui/cheese_form_recipe_book.png");
    }
}
