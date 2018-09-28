package Components;

import java.util.HashMap;

import static Components.ComponentTypes.*;

public class ComponentManager {

    private HashMap<Integer, GraphicsComponent> graphicsComponents;
    private HashMap<Integer, InputComponent> inputComponents;
    private HashMap<Integer, PhysicsComponent> physicsComponents;
    private HashMap<Integer, PositionComponent> positionComponents;
    private HashMap<Integer, VelocityComponent> velocityComponents;

    private HashMap<ComponentTypes, HashMap> componentTypeTable;

    public ComponentManager(){

        graphicsComponents = new HashMap<>();
        inputComponents = new HashMap<>();
        physicsComponents = new HashMap<>();
        positionComponents = new HashMap<>();
        velocityComponents = new HashMap<>();

        componentTypeTable = new HashMap<>();

        initialiseClassTableTable();
    }

    public void initialiseClassTableTable(){
        componentTypeTable.put(GRAPHICS, graphicsComponents);
        componentTypeTable.put(INPUT, inputComponents);
        componentTypeTable.put(PHYSICS, physicsComponents);
        componentTypeTable.put(POSITION, positionComponents);
        componentTypeTable.put(VELOCITY, velocityComponents);
    }

    public void registerComponent(int ID, Component component, ComponentTypes componentType){
        HashMap typeMap = componentTypeTable.get(componentType);
        typeMap.put(ID, component);
    }

    public Component getComponent(int ID, ComponentTypes componentType){
        HashMap typeMap = componentTypeTable.get(componentType);
        Component component = (Component) typeMap.get(ID);
        return component;
    }

    public boolean contains(int ID, ComponentTypes componentType){
        HashMap typeMap = componentTypeTable.get(componentType);
        boolean contained = typeMap.containsKey(ID);
        return contained;
    }

    public void deleteAllComponentsWithID(int ID){
        componentTypeTable.forEach((componentType, componentTable) -> {
            componentTable.remove(ID);
        });
    }
}
