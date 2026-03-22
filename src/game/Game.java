package game;

import board.Color;
import board.Player;
import board.squares.StuckSquare;

public class Game {
    private int boardSize = 30;
    private boolean gameOver = false;
    private Player[] players = new Player[2];
    private StuckSquare[] stuckSquares = new StuckSquare[2];
    private int[] posStuckTab = new int[2];
    private IDisplay display;

    public Game(IDisplay display) {
        this.display = display;

        display.showWelcome();
        players[0] = new Player(display.askName(1), Color.RED);
        players[1] = new Player(display.askName(2), Color.BLUE);

        for (int i = 0; i < stuckSquares.length; i++) {
            stuckSquares[i] = new StuckSquare(boardSize);
            posStuckTab[i] = stuckSquares[i].getPosvalue();
        }

        display.showStuckSquares(posStuckTab);
    }

    private void playTurn(int playerIndex) {
        Player player = players[playerIndex];
        display.showTurnHeader(player);

        if (player.isStuck()) {
            int roll1 = player.roll();
            int roll2 = player.roll();
            if (roll1 == roll2) {
                for (int k = 0; k < stuckSquares.length; k++) {
                    if (player.getPos() == posStuckTab[k]) {
                        stuckSquares[k].unlock(player);
                        break;
                    }
                }
                display.showUnstuck(player);
            } else {
                display.showStuckFail(player, roll1, roll2);
                return;
            }
        }

        int rollValue = Math.max(player.roll(), 1);
        player.forward(rollValue);
        display.showRoll(player, rollValue);
        display.showPosition(player, player.getPos(), boardSize);

        if (player.getPos() >= boardSize) {
            display.showWinner(player);
            gameOver = true;
            return;
        }

        for (int k = 0; k < stuckSquares.length; k++) {
            if (player.getPos() == posStuckTab[k]) {
                stuckSquares[k].stuckEffect(player);
                display.showStuck(player, posStuckTab[k]);
                break;
            }
        }
    }

    private void startTour() {
        display.showRoundHeader();
        for (int i = 0; i < players.length; i++) {
            if (gameOver) break;
            playTurn(i);
        }
        if (!gameOver) display.waitForEnter();
    }

    public void runGame() {
        while (!gameOver) startTour();
    }
}