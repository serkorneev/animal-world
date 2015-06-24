package animalworld.model;

/**
 * @author Sergey Korneev
 */
public abstract class Entity implements Runnable {
    public static int STEP = 30;
    protected int x = 0;
    protected int y = 0;
    protected boolean isRun = false;
    protected Thread entityThread;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void start() {
        entityThread = new Thread(this);
        entityThread.start();
        isRun = true;
    }

    public void stop() {
        entityThread.interrupt();
        synchronized (this) {
            isRun = false;
            notify();
        }
    }

    public abstract void move();

    @Override
    public void run() {
        move();
    }

    public boolean isRun() {
        return isRun;
    }
}
