package board;

public class Player {
    private String name;
    private boolean isStuck = false;
    private Dice[] dice = new Dice[2];

    public int roll(){
        dice[0] = new Dice();
        dice[1] = new Dice();
        dice[0].rollDice();
        dice[1].rollDice();

        return dice[0].getValue() + dice[1].getValue();
    }
}
