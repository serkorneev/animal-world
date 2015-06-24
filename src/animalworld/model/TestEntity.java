package animalworld.model;

/**
 * @author Sergey Korneev
 */
public class TestEntity extends Entity {
    @Override
    public void move() {
        while (!entityThread.isInterrupted()) {
            synchronized (this) {
                x = (x + STEP) % (10 * STEP);
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
