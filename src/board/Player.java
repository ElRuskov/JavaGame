package board;

public class Player {
    private String name;
    private Pawn pawn;
    private boolean isStuck = false;
    private Dice[] dice = new Dice[2];
    private int life = 5;

    public Player(String name, Color color) {
        this.name = name;
        this.pawn = new Pawn(color);
    }

    public int roll() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Dice();
            dice[i].rollDice();
        }
        return dice[0].getValue() + dice[1].getValue();
    }

    public String getName() { return name; }

    public boolean isStuck() { return isStuck; }

    public void setStuck(boolean stuck) { isStuck = stuck; }

    public int getPos() { return pawn.getPos(); }

    public Color getColor() { return pawn.getColor(); }

    public void forward(int rollvalue) { pawn.forward(rollvalue); }

    public void backward(int rollvalue) { pawn.backward(rollvalue); }

    public int getLife() { return life; }
}