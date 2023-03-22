package casinoroyale;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

public class CasinoPanel extends AppPanel {
    private JButton roll;
    private JLabel total, total_View, wins, wins_view, losses, losses_view;
    public CasinoPanel(AppFactory aF){
        super(aF);
        controlPanel.setLayout(new GridLayout(4,1));
        Casino casino = (Casino)model;

        JPanel p = new JPanel();
        total = new JLabel("Total");
        total_View = new JLabel(String.valueOf(casino.getDie1() + casino.getDie2()));
        p.add(total);
        p.add(total_View);
        controlPanel.add(p);

        p = new JPanel();
        wins = new JLabel("Wins");
        wins_view = new JLabel(String.valueOf(casino.getWins()));
        p.add(wins);
        p.add(wins_view);
        controlPanel.add(p);

        p = new JPanel();
        losses = new JLabel("Losses");
        losses_view = new JLabel(String.valueOf(casino.getLosses()));
        p.add(losses);
        p.add(losses_view);
        controlPanel.add(p);

        //adding rollbutton
        roll = new JButton("Roll");
        roll.addActionListener(this);
        controlPanel.add(roll);
    }
    // In response to a property change
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        Casino c = (Casino)model;
        total_View.setText("" + (c.getDie1() + c.getDie2()));
        wins_view.setText(String.valueOf(c.getWins()));
        losses_view.setText(String.valueOf(c.getLosses()));

    }
    // In response to a action peformed
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Casino c = (Casino)model;
        total_View.setText("" + (c.getDie1() + c.getDie2()));
        wins_view.setText(String.valueOf(c.getWins()));
        losses_view.setText(String.valueOf(c.getLosses()));
    }

    public static void main(String[] args){
       AppFactory factory = new CasinoFactory();
       AppPanel a = new CasinoPanel(factory);
       a.display();
    }
}
