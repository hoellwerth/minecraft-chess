package eu.baumistlustig.chess;

import eu.baumistlustig.chess.commands.Test;
import eu.baumistlustig.chess.events.GuiListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
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

        // Events
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new GuiListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return plugin;
    }
}
