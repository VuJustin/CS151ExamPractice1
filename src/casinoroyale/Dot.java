package casinoroyale;

import javax.swing.*;
import java.awt.*;

public class Dot extends JComponent {
    private Color dotcolor;

    public Dot(){
        dotcolor = Color.BLACK;
    }
    public Dot(Color color){
        dotcolor = color;
    }

    public void paintComponent(Graphics gc) {
        Color oldColor = gc.getColor();
        gc.setColor(dotcolor);
        gc.fillOval(10, 10, 10, 10);
        gc.setColor(oldColor);
    }

    public Color getColor() {
        return dotcolor;
    }

    public void setColor(Color dotcolor) {
        this.dotcolor = dotcolor;
    }
}
