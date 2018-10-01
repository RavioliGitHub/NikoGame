package Systems;

import Components.KeyActionComponent;
import Controller.Action;
import Default.Game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class KeyboardInputSystem {

    private Queue<KeyEvent> queue1;
    private Queue<KeyEvent> queue2;

    public KeyboardInputSystem(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void update(){
        KeyEvent keyEvent1 = queue1.poll();
        KeyEvent keyEvent2 = queue2.poll();

        if(keyEvent1 != null){
            reactToKey(keyEvent1);}
        if(keyEvent2 != null){reactToKey(keyEvent2);}
    }

    private void reactToKey(KeyEvent keyEvent){
        int keyEventCode = keyEvent.getKeyCode();
        HashMap<Integer, KeyActionComponent> entityKeyMap =
            Game.getInstance().getComponentManager().getComponentMap(KeyActionComponent.class);

        entityKeyMap.forEach((ID, keyActionComponent) -> {
            if (keyActionComponent.contains(keyEventCode)){
                Action action = keyActionComponent.getAction(keyEventCode);
                action.execute(ID);
            }
        });

    }

    public void addToQueue1(KeyEvent keyEvent) {
        queue1.add(keyEvent);
    }

    public void addToQueue2(KeyEvent keyEvent) {
        queue2.add(keyEvent);
    }
}
