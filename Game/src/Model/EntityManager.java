package Model;

import java.util.ArrayList;

public class EntityManager {
    int ID = 0;

    private ArrayList<Entity> entities;

    /** I’m too lazy to write a "safe" method to get a globally-unique ID; for now,
     I just return 1 the first time I’m called, 2 the second time, etc… */
    public int getNextAvailableID(){
        //Might need a lock here
        ID++;
        return ID;
    }

    /** Whenever you create an entity, you’d better invoke this method too!*/
    public void registerEntity(Entity entity){
        entities.add(entity);
    }


    /**
     * Merely removes the entity from the store. It becomes a GC candidate
     * almost immediately (since all other refs are transient)
     */
    public void killEntity(Entity entity){
        entities.remove(entity);
    }
}
