package de.taventix.signsystem;

import org.bukkit.plugin.java.JavaPlugin;

public class SignSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[ConnectSystem] start loading...");
        System.out.println("[ConnectSystem] start to migrate Commands and Listeners...");
        setupCommandsAndListeners();
    }

    @Override
    public void onDisable() {
        System.out.println("[ConnectSystem] stop running...");
    }

    public void setupCommandsAndListeners() {

    }
}
