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
            { 7, 7, 0, 0, 0, 0, 7, 7, 0 },
            { 0, 0, 7, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 7, 7, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 1, 0, 0, 0 },
            { 1, 1, 0, 0, 0, 0, 1, 1, 0 },
            { 4, 2, 3, 5, 6, 3, 2, 4, 0 },
    };

    Material[] pieces = {
            Material.RED_CONCRETE,
            Material.ORANGE_CONCRETE,
            Material.YELLOW_CONCRETE,
            Material.LIME_CONCRETE,
            Material.GREEN_CONCRETE,
            Material.CYAN_CONCRETE,
            Material.RED_WOOL,
            Material.ORANGE_WOOL,
            Material.YELLOW_WOOL,
            Material.LIME_WOOL,
            Material.GREEN_WOOL,
            Material.CYAN_WOOL,
    };

    String[] pieceNames = {
            "White Pawn",
            "White Knight",
            "White Bishop",
            "White Rook",
            "White Queen",
            "White King",
            "Black Pawn",
            "Black Knight",
            "Black Bishop",
            "Black Rook",
            "Black Queen",
            "Black King",
    };

    public void updateBoard() {

        for (int row = 0; row < 5; row++) {
            for (int file = 0; file < 8; file++) {
                if (board[row][file] == 0) {
                    continue;
                }

                inv.setItem(row * 9 + file,
                        itemBuilder.createGuiItem(
                                pieces[board[row][file] - 1],
                                pieceNames[board[row][file] - 1]
                        )
                );
            }
        }
    }

    public void updatePlayerInv(Player player) {

        int[][] invBoard = {
                board[5],
                board[6],
                board[7],
        };

        for (int row = 0; row < 3; row++) {
            for (int file = 0; file < 9; file++) {

                if (invBoard[row][file] == 0) {
                    continue;
                }

                player.getInventory().setItem((file) + (row * 9) + 9,
                        itemBuilder.createGuiItem(
                                pieces[invBoard[row][file] - 1],
                                pieceNames[invBoard[row][file] - 1]
                        )
                );
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);

        updateBoard();

        updatePlayerInv((Player) ent);
    }
}
