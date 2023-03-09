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

    int[][] board = {
            { 10, 8, 9, 11, 12, 9, 8, 10, 0 },
            { 7, 7, 7, 7, 7, 7, 7, 7, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 4, 2, 3, 5, 6, 3, 2, 4, 0 },
    };

    public void updateBoard() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                switch (board[i][j]) {
                    case 1:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn"));
                        break;
                    case 2:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight"));
                        break;
                    case 3:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop"));
                        break;
                    case 4:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook"));
                        break;
                    case 5:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.GREEN_CONCRETE, "Queen"));
                        break;
                    case 6:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.CYAN_CONCRETE, "King"));
                        break;
                    case 7:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.RED_WOOL, "Pawn"));
                        break;
                    case 8:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.ORANGE_WOOL, "Knight"));
                        break;
                    case 9:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.YELLOW_WOOL, "Bishop"));
                        break;
                    case 10:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.LIME_WOOL, "Rook"));
                        break;
                    case 11:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.GREEN_WOOL, "Queen"));
                        break;
                    case 12:
                        inv.setItem((i * 9) + j, itemBuilder.createGuiItem(Material.CYAN_WOOL, "King"));
                        break;
                }
            }
        }
    }

    public void updatePlayerInv(Player player) {

        int[][] invBoard = {
                board[5],
                board[6],
                board[7],
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {

                switch (invBoard[i][j]) {
                    case 1:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.RED_CONCRETE, "Pawn"));
                        break;
                    case 2:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.ORANGE_CONCRETE, "Knight"));
                        break;
                    case 3:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.YELLOW_CONCRETE, "Bishop"));
                        break;
                    case 4:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.LIME_CONCRETE, "Rook"));
                        break;
                    case 5:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.GREEN_CONCRETE, "Queen"));
                        break;
                    case 6:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.CYAN_CONCRETE, "King"));
                        break;
                    case 7:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.RED_WOOL, "Pawn"));
                        break;
                    case 8:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.ORANGE_WOOL, "Knight"));
                        break;
                    case 9:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.YELLOW_WOOL, "Bishop"));
                        break;
                    case 10:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.LIME_WOOL, "Rook"));
                        break;
                    case 11:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.GREEN_WOOL, "Queen"));
                        break;
                    case 12:
                        player.getInventory().setItem((j) + (i * 9) + 9, itemBuilder.createGuiItem(Material.CYAN_WOOL, "King"));
                        break;
                }
            }
        }
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);

        updateBoard();

        updatePlayerInv((Player) ent);
    }
}
