package board;

import java.security.SecureRandom;

public class Dice {
    private int maxValue = 6;
    private int value;
    private SecureRandom random;

    public Dice() {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void rollDice(){
        value = random.nextInt(maxValue) + 1;
    }
    public int getValue() {
        return value;
    }
}
