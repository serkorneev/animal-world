package animalworld.model;

import animalworld.view.EntitiesPanel;

/**
 * @author Sergey Korneev
 */
public class Test2Entity extends Entity {
    @Override
    public void move() {
        while (!entityThread.isInterrupted()) {
            synchronized (this) {
                y = (y + STEP) >= EntitiesPanel.MAX_HEIGHT ? 0 : y + STEP;
                notify();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
