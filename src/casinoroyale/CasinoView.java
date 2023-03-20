package casinoroyale;

import mvc.*;
import java.awt.*;

public class CasinoView extends View {
    private DieView die1, die2;
    public CasinoView(Model c) {
        super(c);
        //setting casino view to a 1 X 2 Grid Layout
        setLayout(new GridLayout(1,2));
        // Initalizing Die Views
        die1 = new DieView();
        die2 = new DieView();
    }

    public void paintComponent(Graphics gc) {

        super.paintComponent(gc);
        Color oldColor = gc.getColor();

        Casino c = (Casino)model;
        die1 = new DieView();
        die2 = new DieView();

        gc.setColor(oldColor);
    }
}
