package game;

import board.Color;
import board.Player;
import board.squares.StuckSquare;

public class Game {
    private boolean gameOver;
    private Player[] currentPlayer = new Player[2];
    private StuckSquare[] stuckSquare = new StuckSquare[2];

    public Game(){
        currentPlayer[0] = new Player("Esquie",Color.RED);
        currentPlayer[1] = new Player("François",Color.BLUE);
        stuckSquare[0] = new StuckSquare();
        stuckSquare[1] = new StuckSquare();
    }
    private void startTour(){
        int valroll1 = currentPlayer[0].roll();
        int valroll2 = currentPlayer[1].roll();
        currentPlayer[0].pawn.forward(valroll1);
        currentPlayer[1].pawn.forward(valroll2);
    }

    public void runGame(){
        while(!gameOver){
            int boardsize = 36;//TODO Taille Map a changer
            int posP1 = currentPlayer[0].pawn.getPos();
            int posP2 = currentPlayer[1].pawn.getPos();
            int posStuck1 = currentPlayer[0].pawn.getPos();
            int posStuck2 = currentPlayer[1].pawn.getPos();
            if (posP1 >= boardsize || posP2 >= boardsize){
                gameOver = true;
                System.out.println(currentPlayer[0].name+" With color -> "+currentPlayer[0].pawn.getColor() + " - Final Pos = " + currentPlayer[0].pawn.getPos());
                System.out.println(currentPlayer[1].name +" With color -> "+currentPlayer[1].pawn.getColor() + " - Final Pos = " + currentPlayer[1].pawn.getPos());
                System.out.println("--- Game Over ---");
            } else startTour();
        }
    }

}
