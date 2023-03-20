package casinoroyale;
import mvc.*;

import java.util.Random;

public class Casino extends Model {
private int die1, die2, total, wins, losses;
private Random rand;

public Casino(){
    die1 = 0;
    die2 = 0;
    wins = 0;
    total = 0;
    losses = 0;
    rand = new Random();
}

    public int getTotal() {
        return total;
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
        // 0 - 6
        die1 = rand.nextInt(5) + 1;
        die2 = rand.nextInt(5) + 1;
        total = die1 + die2;
        if(total == 7)
            wins++;
        if(total == 3)
            losses++;
        // Update, Notify Subscribers of this change
        changed();
    }
}
