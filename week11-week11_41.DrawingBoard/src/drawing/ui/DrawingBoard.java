package drawing.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int length = 50;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(2*length, length, length, length);
        graphics.fillRect(5*length, length, length, length);
        graphics.fillRect(1*length, 4*length, length, length);
        graphics.fillRect(6*length, 4*length, length, length);
        graphics.fillRect(2*length, 5*length, 4*length, length);
        


    }
}
