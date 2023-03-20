package casinoroyale;

import tools.*;
import mvc.AppFactory;
import mvc.AppPanel;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class CasinoPanel extends AppPanel {
    private JButton roll;
    private JLabel Total, Totalshow, Win, WinShow, Loss, LossShow;
    public CasinoPanel(AppFactory factory){
        super(factory);

        Casino casino = (Casino) model;

        Total = new JLabel("Total");
        super.insertComponent(Total);
        Totalshow = new JLabel(String.valueOf(casino.getDie1() + casino.getDie2()));
        super.insertComponent(Totalshow);

        Win = new JLabel("Wins");
        super.insertComponent(Win);
        WinShow = new JLabel(String.valueOf(casino.getWins()));
        super.insertComponent(WinShow);

        Loss = new JLabel("Losses");
        super.insertComponent(Loss);
        LossShow = new JLabel(String.valueOf(casino.getLosses()));
        super.insertComponent(LossShow);

        roll = new JButton("roll");
        roll.addActionListener(this);
        super.insertComponent(roll);

    }

    public void propertyChange(PropertyChangeEvent evt){
        Casino casino = (Casino) model;
        Totalshow.setText(String.valueOf(casino.getDie1() + casino.getDie2()));
        WinShow.setText(String.valueOf(casino.getWins()));
        LossShow.setText(String.valueOf(casino.getLosses()));
    }
    public static void main(String[] args) {
        AppFactory factory = new CasinoFactory();
        AppPanel panel = new CasinoPanel(factory);
        panel.display();
    }
}
