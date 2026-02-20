package board;

public class Player {
    public String name;
    public Pawn pawn;
    private boolean isStuck = false;
    private Dice[] dice = new Dice[2];

    public Player(String name,Color color) {
        this.name = name;
        this.pawn = new Pawn(color);
    }

    public int roll(){
        dice[0] = new Dice();
        dice[1] = new Dice();
        dice[0].rollDice();
        dice[1].rollDice();

        return dice[0].getValue() + dice[1].getValue();
    }
}
