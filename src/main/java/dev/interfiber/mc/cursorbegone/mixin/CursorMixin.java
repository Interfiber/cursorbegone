package dev.interfiber.mc.cursorbegone.mixin;

import dev.interfiber.mc.cursorbegone.CursorBeGoneConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.lwjgl.glfw.GLFW.*;

@Mixin(MinecraftClient.class)
public class CursorMixin {
    @Inject(at = @At("TAIL"), method = "setScreen")
    private void setScreen(Screen screen, CallbackInfo info) {
//        glfwSetInputMode(MinecraftClient.getInstance().getWindow().getHandle(), GLFW_CURSOR, GLFW_CURSOR_NORMAL);
        long window = MinecraftClient.getInstance().getWindow().getHandle();
        if (screen instanceof GameMenuScreen && CursorBeGoneConfig.hideCursorInPause){
            glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        }
        if (screen instanceof TitleScreen && CursorBeGoneConfig.hideCursorInTitle){
            glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        }
        if (screen instanceof InventoryScreen && CursorBeGoneConfig.hideCursorInBackpack) {
            glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        }
    }
}
