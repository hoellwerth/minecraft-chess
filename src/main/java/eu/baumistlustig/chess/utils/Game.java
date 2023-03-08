package eu.baumistlustig.chess.utils;

public class Game {

    Timer whiteTimer = new Timer(false, 0);
    Timer blackTimer = new Timer(false, 0);

    public void startGame(double time) {
        whiteTimer.setRunning(true);
        whiteTimer.setTime(time);
        blackTimer.setTime(time);
    }

    public void stopGame() {
        whiteTimer.setRunning(false);
        blackTimer.setRunning(false);
    }

    public double[] getTimes() {
        return new double[] { whiteTimer.getTime(), blackTimer.getTime() };
    }

    /*public void makeMove(boolean color, int xa, int ya, int xb, int yb) {
        if (color) {

            return;
        }
    }*/
}
