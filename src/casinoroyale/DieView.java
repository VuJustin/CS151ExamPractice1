package casinoroyale;
import javax.swing.*;
import java.awt.*;

public class DieView extends JPanel {
    private Dot[] dots;
    public DieView(){
        dots = new Dot[6];
        for(int i = 0; i < 6; i++){
            dots[i] = new Dot();
            JPanel j = new JPanel();
            dots[i].add(j);
        }

        setLayout(new GridLayout(2,3));
    }
}
