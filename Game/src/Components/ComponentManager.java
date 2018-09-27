package Components;

import java.util.Hashtable;

public class ComponentManager {
    private Hashtable<Integer, GraphicsComponent> graphicsComponents;
    private Hashtable<Integer, InputComponent> inputComponents;
    private Hashtable<Integer, PhysicsComponent> physicsComponents;

    private Hashtable<Class, Hashtable> classTableTable;

    public ComponentManager(){
        graphicsComponents = new Hashtable<>();
        inputComponents = new Hashtable<>();
        physicsComponents = new Hashtable<>();

        classTableTable = new Hashtable<>();

        initialiseClassTableTable();
    }

    public void initialiseClassTableTable(){
        classTableTable.put(GraphicsComponent.class, graphicsComponents);
        classTableTable.put(InputComponent.class, inputComponents);
        classTableTable.put(PhysicsComponent.class, physicsComponents);
    }

    public void registerComponent(Component component, int ID){
        classTableTable.get(component.getClass()).put(ID ,component);
    }

    public void deleteAllComponentsWithID(int ID){
        classTableTable.forEach((componentClass, componentTable) -> {
            componentTable.remove(ID);
        });
    }
}
