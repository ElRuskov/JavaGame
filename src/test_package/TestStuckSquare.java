package test_package;
import board.squares.StuckSquare;
import board.Color;
import board.Player;

public class TestStuckSquare {
    public static void main(String[] args) {
        Player p1 = new Player("François",Color.RED);
        Player p2 = new Player("Esquie",Color.BLUE);
        StuckSquare sq = new StuckSquare(36);
        sq.stuckEffect(p1);
        System.out.println(p1.getName()+" is stuck ?: " + p1.isStuck());
        System.out.println(p2.getName()+" is stuck ?: " + p2.isStuck());
        System.out.println("What color of square ? : "+sq.getColorSquare());
        System.out.println(sq.getPosvalue());

    }

}
