package board.squares;

import board.Color;
import board.Player;
import java.security.SecureRandom;

public class StuckSquare {
    // TODO faire en sorte que la pos des case ne tombe pas au meme endroit
    private Color colorSquare = Color.BLACK;
    private int maxValue = 36;//TODO Taille Map a changer
    private int posvalue;
    private SecureRandom random;

    public StuckSquare() {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e){
            e.printStackTrace();
        }
        posvalue = random.nextInt(maxValue) + 1;
    }

    public Color getColorSquare() {
        return colorSquare;
    }
    public void unlock(Player player) {player.setStuck(false);}
    public void stuckEffect(Player player) {
        player.setStuck(true);
    }
    public int getPosvalue() {
        return posvalue;
    }
}
