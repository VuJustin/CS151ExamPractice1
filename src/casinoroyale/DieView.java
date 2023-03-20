package casinoroyale;

import javax.swing.*;
import java.awt.*;

public class DieView extends JPanel {
    private Dot dots[];

    public DieView(int dievalue){
        //keep track of die value
        int value = dievalue;

        setLayout(new GridLayout(2,3));
        dots = new Dot[6];
        for(int i = 0; i < 6; i++){
            // Creating a new panel
            JPanel p = new JPanel();
            if(value > 0){
                dots[i] = new Dot(10, 10, Color.RED);
                value--;
            }
            dots[i] = new Dot(10, 10);
            p.add(dots[i]);
            this.add(p);
        }
    }

    public void paintComponent(Graphics gc) {
        Color oldColor = gc.getColor();
        for(int i = 0; i < 6; i++)
            dots[i].draw((Graphics2D)gc);
        gc.setColor(oldColor);
    }

}
