package casinoroyale;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Dot extends JComponent {
    private Ellipse2D.Double dot;
    private Color dotcolor;

    public Dot(int x, int y, Color c){
        dot = new Ellipse2D.Double(x, y, 10, 10);
        dotcolor = c;
    }
    public Dot(int x, int y){
        dot = new Ellipse2D.Double(x, y, 10, 10);
        dotcolor = Color.BLACK;
    }

    public void draw(Graphics2D gc) {
        Color oldColor = gc.getColor();
        gc.setColor(dotcolor);
        gc.fill(dot);
        gc.setColor(oldColor);
    }
}
