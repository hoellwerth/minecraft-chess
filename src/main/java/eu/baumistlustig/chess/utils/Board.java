package eu.baumistlustig.chess.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Board implements Listener {
    private final Inventory inv;

    public Board() {
        inv = Bukkit.createInventory(null, 45, "Chess Board");
    }

    public void initializeBoard() {
        inv.setItem(0, createGuiItem(Material.LIME_CONCRETE, "Rook", "This is black's a rook"));
        inv.setItem(1, createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is black's b knight"));
        inv.setItem(2, createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is black's white bishop"));
        inv.setItem(3, createGuiItem(Material.GREEN_CONCRETE, "Queen", "Black's queen"));
        inv.setItem(4, createGuiItem(Material.CYAN_CONCRETE, "King", "Black's king"));
        inv.setItem(5, createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is black's black bishop"));
        inv.setItem(6, createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is black's g knight"));
        inv.setItem(7, createGuiItem(Material.LIME_CONCRETE, "Rook", "This is black's h rook"));

        inv.setItem(9, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's a pawn"));
        inv.setItem(10, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's b pawn"));
        inv.setItem(11, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's c pawn"));
        inv.setItem(12, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's d pawn"));
        inv.setItem(13, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's e pawn"));
        inv.setItem(14, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's f pawn"));
        inv.setItem(15, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's g pawn"));
        inv.setItem(16, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's h pawn"));
    }

    public void initializePlayerInv(Player player) {
        player.getInventory().setItem(18, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's a pawn"));
        player.getInventory().setItem(19, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's b pawn"));
        player.getInventory().setItem(20, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's c pawn"));
        player.getInventory().setItem(21, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's d pawn"));
        player.getInventory().setItem(22, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's e pawn"));
        player.getInventory().setItem(23, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's f pawn"));
        player.getInventory().setItem(24, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's g pawn"));
        player.getInventory().setItem(25, createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's h pawn"));
        player.getInventory().setItem(27, createGuiItem(Material.LIME_CONCRETE, "Rook", "This is white's a rook"));

        player.getInventory().setItem(28, createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is white's b knight"));
        player.getInventory().setItem(29, createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is white's white bishop"));
        player.getInventory().setItem(30, createGuiItem(Material.GREEN_CONCRETE, "Queen", "White's queen"));
        player.getInventory().setItem(31, createGuiItem(Material.CYAN_CONCRETE, "King", "White's king"));
        player.getInventory().setItem(32, createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is white's black bishop"));
        player.getInventory().setItem(33, createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is white's g knight"));
        player.getInventory().setItem(34, createGuiItem(Material.LIME_CONCRETE, "Rook", "This is white's h rook"));
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);

        initializeBoard();

        initializePlayerInv((Player) ent);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is the best option for your inventory click's
        p.sendMessage("You clicked at slot " + e.getRawSlot());
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
