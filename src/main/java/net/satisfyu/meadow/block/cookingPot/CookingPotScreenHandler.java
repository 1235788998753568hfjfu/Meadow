package net.satisfyu.meadow.block.cookingPot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.satisfyu.meadow.recipes.ModRecipes;
import net.satisfyu.meadow.recipes.pot.CookingPotRecipe;
import net.satisfyu.meadow.screenHandler.ModScreenHandlers;
import net.satisfyu.meadow.screenHandler.RecipeScreenHandler;

import java.util.stream.Stream;

public class CookingPotScreenHandler extends RecipeScreenHandler {

    public CookingPotScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(8), new ArrayPropertyDelegate(2));
    }

    public CookingPotScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.COOKING_POT_SCREEN_HANDLER, syncId, playerInventory, inventory, 7, propertyDelegate);
        buildBlockEntityContainer(playerInventory, inventory);
        buildPlayerContainer(playerInventory);
    }

    private void buildBlockEntityContainer(PlayerInventory playerInventory, Inventory inventory) {
        for (int row = 0; row < 2; row++) {
            for (int slot = 0; slot < 3; slot++) {
                this.addSlot(new Slot(inventory, slot + row + (row * 2), 30 + (slot * 18), 17 + (row * 18)));
            }
        }
        this.addSlot(new Slot(inventory, 6,95, 50));
        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, 7, 124, 26));
    }

    private void buildPlayerContainer(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public boolean isBeingBurned() {
        return propertyDelegate.get(1) != 0;
    }


    private boolean isItemIngredient(ItemStack stack) {
        return recipeStream().anyMatch(cookingPotRecipe -> cookingPotRecipe.getIngredients().stream().anyMatch(ingredient -> ingredient.test(stack)));
    }

    private Stream<CookingPotRecipe> recipeStream() {
        return this.world.getRecipeManager().listAllOfType(ModRecipes.POT_COOKING).stream();
    }

    private boolean isItemContainer(ItemStack stack) {
        return recipeStream().anyMatch(cookingPotRecipe -> cookingPotRecipe.getContainer().isOf(stack.getItem()));
    }
    public int getScaledProgress(int arrowWidth) {
        final int progress = this.propertyDelegate.get(0);
        final int totalProgress = CookingPotBlockEntity.MAX_COOKING_TIME;
        if (progress == 0) {
            return 0;
        }
        return progress * arrowWidth/ totalProgress + 1;
    }


}
