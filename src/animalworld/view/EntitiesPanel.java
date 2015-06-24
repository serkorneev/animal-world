package animalworld.view;

import animalworld.model.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Sergey Korneev
 */
public class EntitiesPanel extends JPanel {
    public static final int MAX_WIDTH = 300;
    public static final int MAX_HEIGHT = 300;
    private ArrayList<EntityView> views = new ArrayList<>();

    public EntitiesPanel() {
        super();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
    }

    /**
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        for (int i = 0; i <= MAX_WIDTH; i += Entity.STEP) {
            g.drawLine(i, 0, i, MAX_HEIGHT);
        }
        for (int i = 0; i <= MAX_HEIGHT; i += Entity.STEP) {
            g.drawLine(0, i, MAX_WIDTH, i);
        }

        for (EntityView view: views) {
            view.paint(g);
        }
    }

    /**
     * @param view
     */
    public void addView(EntityView view) {
        views.add(view);
        (new Thread(view)).start();
    }
}
