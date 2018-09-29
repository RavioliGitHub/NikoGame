package Components;

import Controller.Action;
import java.util.HashMap;

public class KeyActionComponent extends Component{

    private HashMap<Integer, Action> keyActionMap;

    public KeyActionComponent(int ID, HashMap<Integer, Action> keyActionMap) {
        super(ID, ComponentTypes.KEY_ACTION_MAP);
        this.keyActionMap = keyActionMap;
    }

    public boolean contains(int keyEventCode){
        return keyActionMap.containsKey(keyEventCode);
    }

    public Action getAction(int keyEventCode){
        return keyActionMap.get(keyEventCode);
    }
}
