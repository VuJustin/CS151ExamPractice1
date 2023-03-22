package casinoroyale;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class CasinoPanel extends AppPanel {
    private JButton roll;
    private JLabel total, total_View, wins, wins_view, losses, losses_view;
    public CasinoPanel(AppFactory aF){
        super(aF);

        total = new JLabel("Total");
        //total_View = new JLabel()

        roll = new JButton("Roll");
        roll.addActionListener(this);

        //super.insertComponent(roll);
        controlPanel.add(roll);
    }
   public static void main(String[] args){
       AppFactory factory = new CasinoFactory();
       AppPanel a = new CasinoPanel(factory);
       a.display();
    }
}
