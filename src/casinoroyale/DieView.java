package casinoroyale;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DieView extends JPanel {
    private Dot dots[];
    private int value;

    public DieView(int dievalue){
        //keep track of die value
        value = dievalue;

        setLayout(new GridLayout(2,3));
        dots = new Dot[6];
        for(int i = 0; i < 6; i++){
            // Creating a new panel
            JPanel p = new JPanel();
            dots[i] = new Dot();
            //p.add(dots[i]);
            //this.add(p);
            add(dots[i]);
        }
        setBorder(LineBorder.createBlackLineBorder());
    }

    public void paintComponent(Graphics gc) {
        for(int i = 0; i < 6; i++){
            if(value > 0){
                dots[i].setColor(Color.RED);
                value--;
            }
            else
                dots[i].setColor(Color.BLACK);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }
}
