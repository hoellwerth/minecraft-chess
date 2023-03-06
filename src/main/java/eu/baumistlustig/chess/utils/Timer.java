package eu.baumistlustig.chess.utils;

import eu.baumistlustig.chess.Chess;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    private boolean gameRunning;
    private double gameTime;

    public Timer (boolean gameRunning, float gameTime) {
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

    public double getTime() {
        return gameTime;
    }

    public void setTime(double time) {
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

                setTime(getTime() - 0.1);
                Bukkit.broadcastMessage(String.valueOf(Math.round(getTime() * 10.0) / 10.0));
            }
        }.runTaskTimer(Chess.getInstance(), 0, 2);
    }
}
