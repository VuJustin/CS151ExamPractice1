package casinoroyale;

import mvc.View;
import mvc.Model;

import javax.swing.*;
import java.awt.*;

public class CasinoView extends View {
    private DieView dieview1, dieview2;

    public CasinoView(Model m){
        super(m);
        Casino casino = (Casino)model;
        setLayout(new GridLayout(1,2));
       // JPanel d1 = new JPanel();
        dieview1 = new DieView( casino.getDie1());
        //d1.add(dieview1);
        this.add(dieview1);
        //JPanel d2 = new JPanel();
        dieview2 = new DieView( casino.getDie2());
        //d2.add(dieview2);
        this.add(dieview2);
    }
    public void paintComponent(Graphics gc){
        super.paintComponent(gc);
        Casino casino = (Casino)model;
        dieview1.setValue(casino.getDie1());
        dieview2.setValue(casino.getDie2());
    }

}
