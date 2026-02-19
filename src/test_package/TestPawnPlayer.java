package test_package;

import board.Color;
import board.Player;

public class TestPawnPlayer {
    public static void main(String[] args) {
        Player p1 = new Player("François",Color.RED);
        Player p2 = new Player("Esquie",Color.BLUE);
        int val1 = p1.roll();
        int val2 = p2.roll();
        System.out.println(p1.name+" pos Before: " + p1.pawn.getPos());
        System.out.println(p2.name+" pos Before: " + p2.pawn.getPos());
        p1.pawn.forward(val1);
        p2.pawn.forward(val2);

        System.out.println(p1.name+" color: " + p1.pawn.getColor());
        System.out.println(p2.name+" color: " + p2.pawn.getColor());
        System.out.println(p1.name+" pos After 1: " + p1.pawn.getPos());
        System.out.println(p1.name+" pos After 1: " + p2.pawn.getPos());

        val1 = p1.roll();
        val2 = p2.roll();

        p1.pawn.backward(val1);
        p2.pawn.backward(val2);

        System.out.println(p1.name+" pos After 2: " + p1.pawn.getPos());
        System.out.println(p1.name+" pos After 2: " + p2.pawn.getPos());
    }
}
