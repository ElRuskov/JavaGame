package board.squares;

import board.Color;
import board.Player;

public class DolphinSquare {
    private Color colorSquare = Color.ORANGE;

    public void dolphinEffect(Player player) { player.setDolphinTurns(3); }

    public Color getColorSquare() { return colorSquare; }
}