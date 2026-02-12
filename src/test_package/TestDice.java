package test_package;

import board.Dice;


public class TestDice {

    public static void main(String[] args) {

        Dice dice = new Dice();

        for (int i = 0; i < 10; i++) {
            dice.rollDice();
            System.out.println("Lancer " + (i + 1) + " : " + dice.getValue());
        }

    }
}