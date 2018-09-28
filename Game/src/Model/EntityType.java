package Model;

import Components.GraphicsComponent;
import View.Images;

public enum EntityType {
    PLAYER1(Images.PLAYER1),
    DARK_ENEMY(Images.DARK_ENEMY),
    THIEF(Images.THIEF),

    HEARTHBAR(Images.HEARTHBAR),
    BACKPACK(Images.BACKPACK),
    HEALPOTION(Images.HEALPOTION),
    WEAPON(Images.WEAPON),

    TRAPDOOR(Images.TRAPDOOR),
    GROUND(Images.GROUND),

    BREAKABLE_BLOCK(Images.BREAKABLE_BLOCK),
    UNBREAKABLE_BLOCK(Images.UNBREAKABLE_BLOCK);

    private Images image;

    EntityType(final Images image){
        this.image = image;
    }

    public int create(){
        Entity entity = new Entity(this.toString());
        int ID = entity.getID();
        new GraphicsComponent(ID, image);
        return ID;
    }
}
