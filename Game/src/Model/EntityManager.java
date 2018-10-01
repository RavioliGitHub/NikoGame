package Model;

import java.util.ArrayList;

/**
 * See ECS System
 *
 * Mainly has a list of IDs, which represent the  entities
 */
public class EntityManager {
    /**
     * Next available ID
     */
    private int ID;

    /**
     * Currently existing entities
     */
    private ArrayList<Integer> entities;

    /**
     * Name of the entities, only exists for debugging purposes
     */
    private ArrayList<String> names;

    public EntityManager(){
        ID = 0;
        entities = new ArrayList<>();
        names = new ArrayList<>();
    }


    public int createEntity(){
        return createEntity("default");
    }

    public int createEntity(String name){
        ID++;
        entities.add(ID);
        names.add(name);
        return ID;
    }

    public void killEntity(int ID){
        entities.remove(ID);
    }


    public ArrayList<Integer> getEntities() {
        return entities;
    }
}
