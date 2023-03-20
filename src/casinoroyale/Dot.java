package casinoroyale;


import javax.swing.*;
import java.awt.*;
public class Dot extends JComponent{
private Color color;

// Creating a new dot w/ specified color
public Dot(Color color){
    super();
    this.color = color;
}

// Creating new dot, default color is gray
    public Dot(){
    this.color = Color.GRAY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics gc) {
        Color oldColor = gc.getColor();
        gc.setColor(this.color);
        gc.fillOval(10,10, 20,20);
        gc.setColor(oldColor);
    }

}
