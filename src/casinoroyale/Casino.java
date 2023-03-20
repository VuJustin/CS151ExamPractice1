package casinoroyale;

import mvc.Model;
import java.util.Random;

public class Casino extends Model {
private int die1, die2, wins, losses;
protected static Random rand;

    public Casino(){
        die1 = 0;
        die2 = 0;
        wins = 0;
        losses =0;
        rand = new Random();
    }
    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

public void roll(){
    // Bounds die1 & die2 to 0-5 integers, adding 1 makes it 1-6
    die1 = rand.nextInt(6) + 1;
    die2 = rand.nextInt(6) + 1;
    int sum = die1 + die2;
    if(sum == 7)
        wins++;
    if(sum == 3)
        losses++;
    // remember model needs to notify the subscribers for these changes
    changed();
}

}
