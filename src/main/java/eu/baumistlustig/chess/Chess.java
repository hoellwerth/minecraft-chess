package eu.baumistlustig.chess;

import eu.baumistlustig.chess.commands.Test;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Chess extends JavaPlugin {
    private static Chess plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

         // Commands
        Objects.requireNonNull(getCommand("chess")).setExecutor(new Test());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return plugin;
    }
}
