package board.squares;

import board.Color;
import board.Player;

public class StuckSquare {
    private Color colorSquare = Color.BLACK;

    public Color getColorSquare() { return colorSquare; }

    public void unlock(Player player) { player.setStuck(false); }

    public void stuckEffect(Player player) { player.setStuck(true); }
}