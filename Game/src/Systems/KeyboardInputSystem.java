package Systems;

import Components.KeyActionComponent;
import Controller.Action;
import Default.Game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Link between the pressed keys and the action_keyMap
 */
public class KeyboardInputSystem {


    private LinkedList<Integer> pressedKeys;

    public KeyboardInputSystem(){
        pressedKeys = new LinkedList<>();
    }

    public void update(){
        for(Integer keyCode : (LinkedList<Integer>)pressedKeys.clone()){
            reactToKey(keyCode);
        }
    }

    private void reactToKey(int keyEventCode){
        HashMap<Integer, KeyActionComponent> entityKeyMap =
            Game.getInstance().getComponentManager().getComponentMap(KeyActionComponent.class);

        entityKeyMap.forEach((ID, keyActionComponent) -> {
            if (keyActionComponent.contains(keyEventCode)){
                Action action = keyActionComponent.getAction(keyEventCode);
                action.execute(ID);
            }
        });

    }

    public void addToPressedKeys(KeyEvent keyEvent) {
        if (! pressedKeys.contains(keyEvent.getKeyCode())){
            pressedKeys.add(keyEvent.getKeyCode());
        }
    }

    public void removeFromPressedKeys(KeyEvent keyEvent){
        pressedKeys.remove((Integer) keyEvent.getKeyCode());
    }
}
