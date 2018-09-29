package Systems;

import Components.ComponentTypes;
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

        if(keyEvent1 != null){reactToKey(keyEvent1);}
        if(keyEvent2 != null){reactToKey(keyEvent2);}
    }

    private void reactToKey(KeyEvent keyEvent){
        HashMap<Integer, KeyActionComponent> entityKeyMap =
            Game.getInstance().getComponentManager().getComponentMap(ComponentTypes.KEY_ACTION_MAP);

        entityKeyMap.forEach((ID, keyActionComponent) -> {
            if (keyActionComponent.contains(keyEvent)){
                Action action = keyActionComponent.getAction(keyEvent);
                action.execute(ID);
            }
        });

    }

    public Queue<KeyEvent> getQueue1() {
        return queue1;
    }

    public Queue<KeyEvent> getQueue2() {
        return queue2;
    }
}
