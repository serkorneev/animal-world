package animalworld.view;

import animalworld.model.Entity;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sergey Korneev
 */
public class EntitiesPanel extends JPanel {
    public EntitiesPanel() {
        super();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 300));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        for (int i = 0; i < getWidth(); i += Entity.STEP) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = 0; i < getHeight(); i += Entity.STEP) {
            g.drawLine(0, i, getWidth(), i);
        }
    }
}
