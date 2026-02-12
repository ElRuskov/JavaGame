package test_package;

import board.Color;
import board.Pawn;
import board.Player;

public class TestPawnPlayer {
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        int val1 = p1.roll();
        int val2 = p2.roll();
        Pawn pawn1 = new Pawn(Color.BLUE);
        Pawn pawn2 = new Pawn(Color.RED);
        System.out.println("Pawn 1 pos: " + pawn1.getPos());
        System.out.println("Pawn 2 pos: " + pawn2.getPos());
        pawn1.forward(val1);
        pawn2.forward(val2);

        System.out.println("Pawn 1 color: " + pawn1.getColor());
        System.out.println("Pawn 2 color: " + pawn2.getColor());
        System.out.println("Pawn 1 pos: " + pawn1.getPos());
        System.out.println("Pawn 2 pos: " + pawn2.getPos());

    }
}
