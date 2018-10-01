package Components;

import Controller.Action;
import java.util.HashMap;

/**
 * Add to an entity so it reacts to certain keys
 */
public class KeyActionComponent extends Component{

    /**
     * Maps pressed keys to actions that will be executed
     */
    private HashMap<Integer, Action> keyActionMap;

    public KeyActionComponent(int ID, HashMap<Integer, Action> keyActionMap) {
        super(ID, KeyActionComponent.class);
        this.keyActionMap = keyActionMap;
    }

    public boolean contains(int keyEventCode){
        return keyActionMap.containsKey(keyEventCode);
    }

    public Action getAction(int keyEventCode){
        return keyActionMap.get(keyEventCode);
    }
}
