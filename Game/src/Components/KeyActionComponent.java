package Components;

import Controller.Action;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyActionComponent extends Component{

    private HashMap<KeyEvent, Action> keyActionMap;

    public KeyActionComponent(int ID, ComponentTypes componentType, HashMap<KeyEvent, Action> keyActionMap) {
        super(ID, componentType);
        this.keyActionMap = keyActionMap;
    }

    public boolean contains(KeyEvent keyEvent){
        return keyActionMap.containsKey(keyEvent);
    }

    public Action getAction(KeyEvent keyEvent){
        return keyActionMap.get(keyEvent);
    }
}
