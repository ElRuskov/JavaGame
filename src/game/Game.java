package game;

import board.Color;
import board.Player;

public class Game {
    public boolean gameOver;
    private Player[] currentPlayer = new Player[2];

    public Game(){
        currentPlayer[0] = new Player("Esquie",Color.RED);
        currentPlayer[1] = new Player("François",Color.BLUE);
    }
    public void startTour(){
        int valroll1 = currentPlayer[0].roll();
        int valroll2 = currentPlayer[1].roll();
        currentPlayer[0].pawn.forward(valroll1);
        currentPlayer[1].pawn.forward(valroll2);
    }

    public void runGame(){
        while(!gameOver){
            int pos1 = currentPlayer[0].pawn.getPos();
            int pos2 = currentPlayer[1].pawn.getPos();
            if (pos1 >= 36 || pos2 >= 36){
                gameOver = true;
                System.out.println(currentPlayer[0].name + " - Pos Final =" + currentPlayer[0].pawn.getPos());
                System.out.println(currentPlayer[1].name + " - Pos Final =" + currentPlayer[1].pawn.getPos());
                System.out.println("Game Over");
            }else startTour();
        }
    }

}
