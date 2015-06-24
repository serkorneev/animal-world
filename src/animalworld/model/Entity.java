package animalworld.model;

/**
 * @author Sergey Korneev
 */
public abstract class Entity implements Runnable {
    public static int STEP = 30;
    protected int x = 0;
    protected int y = 0;
    protected Thread entityThread;

    /**
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * @return int
     */
    public int getY() {
        return y;
    }

    public void start() {
        entityThread = new Thread(this);
        entityThread.start();
    }

    public void stop() {
        entityThread.interrupt();
    }

    public abstract void move();

    @Override
    public void run() {
        move();
    }
}
