package test_package;

import board.Color;
import board.Player;

public class TestPawnPlayer {
    public static void main(String[] args) {
        Player p1 = new Player("François",Color.RED);
        Player p2 = new Player("Esquie",Color.BLUE);
        int val1 = p1.roll();
        int val2 = p2.roll();
        System.out.println(p1.getName()+" pos Before: " + p1.getPos());
        System.out.println(p2.getName()+" pos Before: " + p2.getPos());
        p1.forward(val1);
        p2.forward(val2);

        System.out.println(p1.getName()+" color: " + p1.getColor());
        System.out.println(p2.getName()+" color: " + p2.getColor());
        System.out.println(p1.getName()+" pos After 1: " + p1.getPos());
        System.out.println(p1.getName()+" pos After 1: " + p2.getPos());

        val1 = p1.roll();
        val2 = p2.roll();

        p1.backward(val1);
        p2.backward(val2);

        System.out.println(p1.getName()+" pos After 2: " + p1.getPos());
        System.out.println(p1.getName()+" pos After 2: " + p2.getPos());
    }
}
