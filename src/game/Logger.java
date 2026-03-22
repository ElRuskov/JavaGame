package game;

import board.Color;
import board.Player;

import java.util.Scanner;

public class Logger implements IDisplay {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showWelcome() {
        System.out.println("=== The Pirates' Game ===");
        System.out.println("\nJack Le Borgne and Bill Jambe de Bois, stranded on a desert island, race to find the only hidden rowboat to claim captaincy of 'Le Sanguinaire'.\nRoll 2 dice, move your pawn (RED: Jack, BLUE: Bill) across 30 squares — first to reach square 30 wins!");
        System.out.println("\nJack Le Borgne et Bill Jambe de Bois, échoués sur une île déserte, cherchent la seule barque cachée pour prendre le commandement du « Sanguinaire ».\nLancez 2 dés, avancez votre pion (ROUGE : Jack, BLEU : Bill) sur 30 cases — le premier à atteindre la case 30 gagne !");
        System.out.println("\n(Press Enter to keep the default pirate name)");
        System.out.println();
    }

    @Override
    public String askName(int playerNumber, String defaultName) {
        System.out.print("Enter name [" + defaultName + "]: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            return defaultName;
        } else {
            return name;
        }
    }

    @Override
    public void showRoundHeader() {
        System.out.println("\n===== ROUND =====");
    }

    @Override
    public void showTurnHeader(Player player) {
        System.out.println("\n--- " + player.getName() + "'s turn [" + player.getColor() + "] ---");
    }

    @Override
    public void showWinner(Player player) {
        System.out.println("🏆 " + player.getName() + " [" + player.getColor() + "] wins the game!");
        System.out.println("[ with " + player.getLife() + " HP ]");
    }

    @Override
    public void showRoll(Player player, int rollValue) {
        System.out.println(player.getName() + " rolled -> " + rollValue);
    }

    @Override
    public void showPosition(Player player, int position, int boardSize) {
        System.out.println("[TRACE] " + player.getName() + " is at position " + position + "/" + boardSize);
    }

    @Override
    public void showUnstuck(Player player) {
        System.out.println("✅ " + player.getName() + " [" + player.getColor() + "] is now unstuck!");
    }

    @Override
    public void showStuck(Player player, int squarePosition, Color squareColor) {
        System.out.println("⛔ " + player.getName() + " [" + player.getColor() + "] is stuck on square " + squarePosition + " [" + squareColor + "]");
    }

    @Override
    public void showStuckFail(Player player, int roll1, int roll2) {
        System.out.println("❌ " + player.getName() + " tried to get unstuck (" + roll1 + " | " + roll2 + ") — failed, turn lost!");
    }

    @Override
    public void showStuckSquares(int[] positions, Color squareColor) {
        System.out.print("[TRACE] Stuck squares [" + squareColor + "] generated at positions: ");
        for (int i = 0; i < positions.length; i++) {
            System.out.print(positions[i]);
            if (i < positions.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    @Override
    public void showDolphinSquares(int[] positions, Color squareColor) {
        System.out.print("[TRACE] Dolphin squares [" + squareColor + "] generated at positions: ");
        for (int i = 0; i < positions.length; i++) {
            System.out.print(positions[i]);
            if (i < positions.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    @Override
    public void showDolphin(Player player, int squarePosition, Color squareColor) {
        System.out.println("🐬 " + player.getName() + " landed on a dolphin square " + squarePosition + " [" + squareColor + "]! Dice doubled for 3 turns.");
    }

    @Override
    public void showDolphinActive(Player player) {
        System.out.println("🐬 " + player.getName() + " has dolphin boost active (" + player.getDolphinTurns() + " turns left).");
    }

    @Override
    public void waitForEnter() {
        System.out.print("[ Press Enter to continue... ]");
        scanner.nextLine();
    }
}