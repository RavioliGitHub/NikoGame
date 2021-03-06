package Model;

import Components.*;
import Controller.Action;
import Default.Game;
import View.Images;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Not actually needed, but simplifies life
 */
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
    UNBREAKABLE_BLOCK(Images.UNBREAKABLE_BLOCK),

    PLINFA(Images.PLINFA);

    private Images image;

    EntityType(final Images image){
        this.image = image;
    }

    public int create(int x, int y){
        int ID = Game.getInstance().getEntityManager().createEntity(this.toString());
        new GraphicsComponent(ID, image);
        new PositionComponent(ID, x, y);
        return ID;
    }

    public void testPlayerComponentCreation(int ID){
        HashMap<Integer, Action> keyEventActionHashMap = new HashMap<>();
        keyEventActionHashMap.put(KeyEvent.VK_W, Action.MOVE_UP);
        keyEventActionHashMap.put(KeyEvent.VK_S, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_D, Action.MOVE_RIGHT);
        keyEventActionHashMap.put(KeyEvent.VK_A, Action.MOVE_LEFT);

        new DirectionComponent(ID, Direction.UP);

        new KeyActionComponent(ID, keyEventActionHashMap);

        new VelocityComponent(ID, Direction.UP, 0, 5);

        QuickFixComponent quickFixComponent = new QuickFixComponent(ID);
        quickFixComponent.setCrossable(false);
        quickFixComponent.setDraggable(true);

    }

    public void testBackPackComponentCreation2(int ID){
        HashMap<Integer, Action> keyEventActionHashMap = new HashMap<>();

        keyEventActionHashMap.put(KeyEvent.VK_UP, Action.MOVE_UP);
        keyEventActionHashMap.put(KeyEvent.VK_DOWN, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_CLEAR, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_RIGHT, Action.MOVE_RIGHT);
        keyEventActionHashMap.put(KeyEvent.VK_LEFT, Action.MOVE_LEFT);

        new KeyActionComponent(ID, keyEventActionHashMap);

        new VelocityComponent(ID, Direction.UP, 0, 1);

        QuickFixComponent quickFixComponent = new QuickFixComponent(ID);
        quickFixComponent.setCrossable(false);
        quickFixComponent.setDraggable(true);
    }


    public void testNinjaComponentCreationAZERTY(int ID){
        HashMap<Integer, Action> keyEventActionHashMap = new HashMap<>();

        keyEventActionHashMap.put(KeyEvent.VK_Z, Action.MOVE_UP);
        keyEventActionHashMap.put(KeyEvent.VK_S, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_Q, Action.MOVE_LEFT);
        keyEventActionHashMap.put(KeyEvent.VK_D, Action.MOVE_RIGHT);

        new KeyActionComponent(ID, keyEventActionHashMap);

        new VelocityComponent(ID, Direction.UP, 0, 5);

        QuickFixComponent quickFixComponent = new QuickFixComponent(ID);
        quickFixComponent.setCrossable(false);
        quickFixComponent.setDraggable(false);
    }

    public void walkingWallCreation(int x,int y){
        int ID = this.create(x,y);
        HashMap<Integer, Action> keyEventActionHashMap = new HashMap<>();

        keyEventActionHashMap.put(KeyEvent.VK_UP, Action.MOVE_UP);
        keyEventActionHashMap.put(KeyEvent.VK_DOWN, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_CLEAR, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_RIGHT, Action.MOVE_RIGHT);
        keyEventActionHashMap.put(KeyEvent.VK_LEFT, Action.MOVE_LEFT);
        new KeyActionComponent(ID, keyEventActionHashMap);

        new VelocityComponent(ID, Direction.UP, 0, 5);

        QuickFixComponent quickFixComponent = new QuickFixComponent(ID);
        quickFixComponent.setCrossable(false);
        quickFixComponent.setDraggable(true);
    }
}
