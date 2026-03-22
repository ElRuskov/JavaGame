package board.squares;

import board.Color;
import board.Player;
import java.security.SecureRandom;

public class StuckSquare {
    private Color colorSquare = Color.BLACK;
    private int posvalue;
    private SecureRandom random;

    public StuckSquare(int boardSize) {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            e.printStackTrace();
        }
        posvalue = random.nextInt(boardSize) + 1;
    }

    public Color getColorSquare() {
        return colorSquare;
    }

    public void unlock(Player player) { player.setStuck(false); }

    public void stuckEffect(Player player) { player.setStuck(true); }

    public int getPosvalue() { return posvalue; }
}