package Model;

import java.util.ArrayList;

public class EntityManager {
    private int ID;

    private ArrayList<Integer> entities;
    private ArrayList<String> names;

    public EntityManager(){
        ID = 0;
        entities = new ArrayList<>();
        names = new ArrayList<>();
    }


    public int createEntity(){
        ID++;
        entities.add(ID);
        names.add("default");
        return ID;
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
