package eu.baumistlustig.chess.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Board implements Listener {
    private final Inventory inv;

    public Board() {
        inv = Bukkit.createInventory(null, 45, "Chess Board");
    }

    ItemBuilder itemBuilder = new ItemBuilder();

    public void initializeBoard() {
        inv.setItem(0, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook", "This is black's a rook"));
        inv.setItem(1, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is black's b knight"));
        inv.setItem(2, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is black's white bishop"));
        inv.setItem(3, itemBuilder.createGuiItem(Material.GREEN_CONCRETE, "Queen", "Black's queen"));
        inv.setItem(4, itemBuilder.createGuiItem(Material.CYAN_CONCRETE, "King", "Black's king"));
        inv.setItem(5, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is black's black bishop"));
        inv.setItem(6, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is black's g knight"));
        inv.setItem(7, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook", "This is black's h rook"));

        inv.setItem(9, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's a pawn"));
        inv.setItem(10, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's b pawn"));
        inv.setItem(11, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's c pawn"));
        inv.setItem(12, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's d pawn"));
        inv.setItem(13, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's e pawn"));
        inv.setItem(14, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's f pawn"));
        inv.setItem(15, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's g pawn"));
        inv.setItem(16, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is black's h pawn"));
    }

    public void initializePlayerInv(Player player) {
        player.getInventory().setItem(18, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's a pawn"));
        player.getInventory().setItem(19, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's b pawn"));
        player.getInventory().setItem(20, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's c pawn"));
        player.getInventory().setItem(21, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's d pawn"));
        player.getInventory().setItem(22, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's e pawn"));
        player.getInventory().setItem(23, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's f pawn"));
        player.getInventory().setItem(24, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's g pawn"));
        player.getInventory().setItem(25, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn", "This is white's h pawn"));
        player.getInventory().setItem(27, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook", "This is white's a rook"));

        player.getInventory().setItem(28, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is white's b knight"));
        player.getInventory().setItem(29, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is white's white bishop"));
        player.getInventory().setItem(30, itemBuilder.createGuiItem(Material.GREEN_CONCRETE, "Queen", "White's queen"));
        player.getInventory().setItem(31, itemBuilder.createGuiItem(Material.CYAN_CONCRETE, "King", "White's king"));
        player.getInventory().setItem(32, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop", "This is white's black bishop"));
        player.getInventory().setItem(33, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight", "This is white's g knight"));
        player.getInventory().setItem(34, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook", "This is white's h rook"));
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);

        initializeBoard();

        initializePlayerInv((Player) ent);
    }

    // Check for clicks on items
    /*@EventHandler
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
    }*/
}
