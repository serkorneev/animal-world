package animalworld.view;

import animalworld.model.Entity;
import java.awt.*;

/**
 * @author Sergey Korneev
 */
public class EntityView implements Runnable {
    private final Entity entity;

    public EntityView(Entity e) {
        entity = e;
    }

    public void run() {
        int lastX = 0;
        int lastY = 0;
        Graphics graphics = MainFrame.ep.getGraphics();
        synchronized (entity) {
            while (true) {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(lastX + 3, lastY + 3, Entity.STEP - 6, Entity.STEP - 6);
                graphics.setColor(Color.RED);
                graphics.fillOval(
                        entity.getX() + 3,
                        entity.getY() + 3,
                        Entity.STEP - 6,
                        Entity.STEP - 6
                );
                lastX = entity.getX();
                lastY = entity.getY();

                try {
                    entity.wait();
                } catch (InterruptedException e) {
                    break;
                }

                if (!entity.isRun()) {
                    break;
                }
            }
        }
    }
}
