package dev.interfiber.mc.cursorbegone;

import eu.midnightdust.lib.config.MidnightConfig;

public class CursorBeGoneConfig extends MidnightConfig {
    @Entry // Hide the cursor in the pause menu
    public static boolean hideCursorInPause = false;
    @Entry // Hide the cursor in the title screen
    public static boolean hideCursorInTitle = true;
    @Entry // Hide the cursor in the inventory
    public static boolean hideCursorInBackpack = true;
}
