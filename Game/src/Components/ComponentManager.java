package Components;

import java.util.HashMap;

public class ComponentManager {

    private HashMap<Class, HashMap<Integer, Component>> class_ID_ComponentHashMap;

    public ComponentManager(){
        class_ID_ComponentHashMap = new HashMap<>();
        for(Class componentSubClass : Component.getSubClasses()){
            class_ID_ComponentHashMap.put(componentSubClass, new HashMap<>());
        }
    }

    public void registerComponent(int ID, Component component, Class componentSubClass){
        assert componentSubClass.getSuperclass() == Component.class;
        HashMap typeMap = class_ID_ComponentHashMap.get(componentSubClass);
        typeMap.put(ID, component);
    }

    public Component getComponent(int ID, Class componentSubClass){
        assert componentSubClass.getSuperclass() == Component.class;
        HashMap typeMap = class_ID_ComponentHashMap.get(componentSubClass);
        Component component = (Component) typeMap.get(ID);
        return component;
    }

    public HashMap getComponentMap(Class componentSubClass){
        HashMap typeMap = class_ID_ComponentHashMap.get(componentSubClass);
        return typeMap;
    }

    public boolean contains(int ID, Class componentSubClass){
        HashMap typeMap = class_ID_ComponentHashMap.get(componentSubClass);
        boolean contained = typeMap.containsKey(ID);
        return contained;
    }

    public void deleteAllComponentsWithID(int ID){
        class_ID_ComponentHashMap.forEach((componentType, componentTable) -> {
            componentTable.remove(ID);
        });
    }
}
