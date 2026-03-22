package game;

import board.Color;
import board.Player;
import board.squares.DolphinSquare;
import board.squares.StuckSquare;

import java.security.SecureRandom;

public class Game {
    private int boardSize = 30;
    private boolean gameOver = false;
    private Player[] players = new Player[2];
    private StuckSquare[] stuckSquares = new StuckSquare[2];
    private DolphinSquare[] dolphinSquares = new DolphinSquare[2];
    private int[] posStuckTab = new int[2];
    private int[] posDolphinTab = new int[2];
    private int[] usedPositions;
    private int usedCount = 0;
    private IDisplay display;
    private SecureRandom random;

    public Game(IDisplay display) {
        this.display = display;
        usedPositions = new int[stuckSquares.length + dolphinSquares.length];

        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            e.printStackTrace();
        }

        display.showWelcome();
        players[0] = new Player(display.askName(1, "Jack Le Borgne"), Color.RED);
        players[1] = new Player(display.askName(2, "Bill Jambe de Bois"), Color.BLUE);

        for (int i = 0; i < stuckSquares.length; i++) {
            int pos = generateUniquePosition();
            stuckSquares[i] = new StuckSquare();
            posStuckTab[i] = pos;
        }

        for (int i = 0; i < dolphinSquares.length; i++) {
            int pos = generateUniquePosition();
            dolphinSquares[i] = new DolphinSquare();
            posDolphinTab[i] = pos;
        }

        display.showStuckSquares(posStuckTab, stuckSquares[0].getColorSquare());
        display.showDolphinSquares(posDolphinTab, dolphinSquares[0].getColorSquare());
    }

    private int generateUniquePosition() {
        int pos;
        boolean alreadyUsed;
        do {
            pos = random.nextInt(boardSize) + 1;
            alreadyUsed = false;
            for (int i = 0; i < usedCount; i++) {
                if (usedPositions[i] == pos) {
                    alreadyUsed = true;
                }
            }
        } while (alreadyUsed);
        usedPositions[usedCount] = pos;
        usedCount++;
        return pos;
    }

    private void tryUnlock(Player player) {
        for (int k = 0; k < stuckSquares.length; k++) {
            if (player.getPos() == posStuckTab[k]) {
                stuckSquares[k].unlock(player);
                return;
            }
        }
    }

    private void checkStuckSquare(Player player) {
        for (int k = 0; k < stuckSquares.length; k++) {
            if (player.getPos() == posStuckTab[k]) {
                stuckSquares[k].stuckEffect(player);
                display.showStuck(player, posStuckTab[k], stuckSquares[k].getColorSquare());
                return;
            }
        }
    }

    private void checkDolphinSquare(Player player) {
        for (int k = 0; k < dolphinSquares.length; k++) {
            if (player.getPos() == posDolphinTab[k]) {
                dolphinSquares[k].dolphinEffect(player);
                display.showDolphin(player, posDolphinTab[k], dolphinSquares[k].getColorSquare());
                return;
            }
        }
    }

    private void playTurn(int playerIndex) {
        Player player = players[playerIndex];
        display.showTurnHeader(player);

        if (player.getDolphinTurns() > 0) {
            display.showDolphinActive(player);
        }

        if (player.isStuck()) {
            int roll1 = player.roll();
            int roll2 = player.roll();
            if (roll1 == roll2) {
                tryUnlock(player);
                display.showUnstuck(player);
            } else {
                display.showStuckFail(player, roll1, roll2);
                return;
            }
        }

        int rollValue = player.roll();
        player.forward(rollValue);
        display.showRoll(player, rollValue);
        display.showPosition(player, player.getPos(), boardSize);

        if (player.getPos() >= boardSize) {
            display.showWinner(player);
            gameOver = true;
            return;
        }

        checkStuckSquare(player);
        checkDolphinSquare(player);
    }

    private void startTour() {
        display.showRoundHeader();
        for (int i = 0; i < players.length; i++) {
            if (gameOver) return;
            playTurn(i);
        }
        if (!gameOver) display.waitForEnter();
    }

    public void runGame() {
        while (!gameOver) startTour();
    }
}