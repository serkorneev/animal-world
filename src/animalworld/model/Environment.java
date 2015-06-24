package animalworld.model;

import java.util.ArrayList;

/**
 * @author Sergey Korneev
 */
public class Environment {
    private ArrayList<Entity> entities = new ArrayList<>();

    public Environment() {
        addEntity(new TestEntity());
        addEntity(new Test2Entity());
    }

    public void start() {
        for (Entity e: entities) {
            e.start();
        }
    }

    public void stop() {
        for (Entity e: entities) {
            e.stop();
        }
    }

    /**
     * @return ArrayList<Entity>
     */
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * @param e
     */
    public void addEntity(Entity e) {
        entities.add(e);
    }
}
