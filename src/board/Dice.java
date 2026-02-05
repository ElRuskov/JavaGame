package board;

import java.security.SecureRandom;

public class Dice {
    private Integer maxValue = 6;
    private Integer value;
    private SecureRandom random;

    public Dice() {
        try {
            random = SecureRandom.getInstanceStrong():
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void rolldice(){
        value = random.nextInt(maxValue) + 1;
    }
    public Integer getValue() {
        return value;
    }

}
