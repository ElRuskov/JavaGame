package game;

import board.Color;
import board.Player;
import board.squares.StuckSquare;

public class Game {
    private boolean gameOver;
    private Player[] currentPlayer = new Player[2];
    private StuckSquare[] stuckSquare = new StuckSquare[2];
    private int [] posPTab = new int[2];
    private int [] posStuckTab = new int[2];


    public Game(){
        currentPlayer[0] = new Player("Esquie",Color.RED);
        currentPlayer[1] = new Player("François",Color.BLUE);
        for (int i = 0; i < 2; i++) {
            posPTab[i] = 0;
            posStuckTab[i] = 0;

        }

        for (int i = 0; i < 2; i++) {
            stuckSquare[i] = new StuckSquare();
            posStuckTab[i] = stuckSquare[i].getPosvalue();
        }

    }
    private void startTour(){
        for (int l = 0; l < 2; l++) {
            int boardsize = 36;//TODO Taille Map a changer
            if (posPTab[l] >= boardsize) {
                System.out.println(currentPlayer[l].getName() + " With color -> " + currentPlayer[l].getColor() + " Win the game !");
                gameOver = true;
            }else {
                for (int i = 0; i < 2; i++) {
                    int valroll = currentPlayer[i].roll();
                    currentPlayer[i].forward(valroll);
                    System.out.println("Roll player "+currentPlayer[i].getName()+" Roll = "+valroll);
                }
                for (int i = 0; i < 2; i++) {
                    int posP = currentPlayer[i].getPos();
                    posPTab[i] = posP;
                    System.out.println("[TRACE postab ]"+posPTab[i]);
                    if (currentPlayer[i].isStuck()){
                        int valRollUnstuck1 = currentPlayer[i].roll();
                        int valRollUnstuck2 = currentPlayer[i].roll();
                        if (valRollUnstuck1 == valRollUnstuck2){
                            stuckSquare[i].unlock(currentPlayer[i]);
                            System.out.println(currentPlayer[i].getName()+" With color -> "+currentPlayer[i].getColor() + "Is unstuck ");
                        }
                    }
                }

                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (posPTab[j] == posStuckTab[k] ){
                            System.out.println(currentPlayer[j].getName()+" With color -> "+currentPlayer[j].getColor() + "Is stuck into case -> "+posStuckTab[k]);
                            stuckSquare[k].stuckEffect(currentPlayer[j]);
                        }
                    }
                }
            }
        }
    }

    public void runGame(){
        while(!gameOver){
            startTour();
            System.out.println("TOUR");

        }
    }

}
