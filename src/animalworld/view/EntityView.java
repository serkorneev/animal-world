package animalworld.view;

import animalworld.model.Entity;
import java.awt.*;

/**
 * @author Sergey Korneev
 */
public class EntityView implements Runnable {
    private static final int PADDING = 3;
    private final Entity entity;
    private int lastX = 0;
    private int lastY = 0;

    public EntityView(Entity e) {
        entity = e;
    }

    public void run() {
        synchronized (entity) {
            while (true) {
                try {
                    entity.wait();
                } catch (InterruptedException e) {
                    break;
                }
                paint(MainFrame.ep.getGraphics());
            }
        }
    }

    /**
     * @param graphics
     */
    public void paint(Graphics graphics) {
        synchronized (MainFrame.ep.getGraphics()) {
            graphics.setColor(MainFrame.ep.getBackground());
            graphics.fillRect(
                    lastX + PADDING,
                    lastY + PADDING,
                    Entity.STEP - 2 * PADDING,
                    Entity.STEP - 2 * PADDING
            );
            graphics.setColor(Color.RED);
            graphics.fillOval(
                    entity.getX() + PADDING,
                    entity.getY() + PADDING,
                    Entity.STEP - 2 * PADDING,
                    Entity.STEP - 2 * PADDING
            );
            lastX = entity.getX();
            lastY = entity.getY();
        }
    }
}
