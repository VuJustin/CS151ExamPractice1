package casinoroyale;

import mvc.View;
import mvc.Model;

import javax.swing.*;
import java.awt.*;

public class CasinoView extends View {
    private DieView dieview1, dieview2;

    public CasinoView(Model m){
        super(m);
        setLayout(new GridLayout(1,2));
        JPanel d1 = new JPanel();
        dieview1 = new DieView( ((Casino) model).getDie1());
        d1.add(dieview1);
        this.add(d1);
        JPanel d2 = new JPanel();
        dieview2 = new DieView( ((Casino) model).getDie2());
        d2.add(dieview2);
        this.add(d2);
    }


}
