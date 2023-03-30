package eu.baumistlustig.chess.events;

import eu.baumistlustig.chess.utils.Game;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {
        if (Game.isRunning()) {
            Bukkit.getLogger().info("Debug");
            e.setCancelled(true);
        }
    }
}
