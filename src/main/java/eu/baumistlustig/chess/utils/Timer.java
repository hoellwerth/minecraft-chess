package eu.baumistlustig.chess.utils;

import eu.baumistlustig.chess.Chess;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    private boolean gameRunning;
    private int gameTime;

    public Timer (boolean gameRunning, int gameTime) {
        this.gameRunning = gameRunning;
        this.gameTime = gameTime;
        run();
    }

    public boolean isRunning() {
        return gameRunning;
    }

    public void setRunning(boolean running) {
        this.gameRunning = running;
    }

    public int getTime() {
        return gameTime;
    }

    public void setTime(int time) {
        this.gameTime = time;
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isRunning()) {
                    cancel();
                    return;
                }

                if (getTime() <= 0) {
                    setRunning(false);
                    cancel();
                    return;
                }

                setTime(getTime() - 1);
            }
        }.runTaskTimer(Chess.getInstance(), 0, 20);
    }
}
