package animalworld.model;

/**
 * @author Sergey Korneev
 */
public class Test2Entity extends Entity {
    @Override
    public void move() {
        while (!entityThread.isInterrupted()) {
            synchronized (this) {
                y = (y + STEP) % (10 * STEP);
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
