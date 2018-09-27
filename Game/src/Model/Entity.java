package Model;

import Default.Game;

public class Entity {
    private int ID;

    /**
     * For debugging purposes only
     */
    private String name;

    public Entity(){
        this.ID = Game.getInstance().getEntityManager().getNextAvailableID();
    }
    public Entity(String name){
        this.ID = Game.getInstance().getEntityManager().getNextAvailableID();
        this.name = name;
    }
}
