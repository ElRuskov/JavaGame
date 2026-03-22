package game;

import board.Color;
import board.Player;

public interface IDisplay {

    void showWelcome();

    String askName(int playerNumber, String defaultName);

    void showRoundHeader();

    void showWinner(Player player);

    void showRoll(Player player, int rollValue);

    void showPosition(Player player, int position, int boardSize);

    void showUnstuck(Player player);

    void showStuck(Player player, int squarePosition, Color squareColor);

    void showStuckFail(Player player, int roll1, int roll2);

    void showTurnHeader(Player player);

    void showStuckSquares(int[] positions, Color squareColor);

    void showDolphinSquares(int[] positions, Color squareColor);

    void showDolphin(Player player, int squarePosition, Color squareColor);

    void showDolphinActive(Player player);

    void waitForEnter();
}