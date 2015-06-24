package animalworld.model;

import animalworld.view.EntitiesPanel;

/**
 * @author Sergey Korneev
 */
public class TestEntity extends Entity {
    @Override
    public void move() {
        while (!entityThread.isInterrupted()) {
            synchronized (this) {
                x = (x + STEP) >= EntitiesPanel.MAX_WIDTH ? 0 : x + STEP;
                notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
