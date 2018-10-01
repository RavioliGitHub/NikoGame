package Components;

import Default.Game;

import java.util.ArrayList;

/**
 * Super class for components
 * Use to force behavior upon all components
 */
public abstract class Component{
    static {
        initialiseSubclasses();
    }

    private static void initialiseSubclasses(){
        subClasses = new ArrayList<>();
        subClasses.add(DirectionComponent.class);
        subClasses.add(GraphicsComponent.class);
        subClasses.add(InputComponent.class);
        subClasses.add(KeyActionComponent.class);
        subClasses.add(PhysicsComponent.class);
        subClasses.add(PositionComponent.class);
        subClasses.add(VelocityComponent.class);
    }

    /**
     * All the different types components that exist and are used
     */
    private static ArrayList<Class> subClasses;

    /**
     * Ensures that they all are constructed with an ID and the correct component type
     * @param ID Entity ID
     * @param componentSubClass Subclass
     */
    public Component(int ID, Class componentSubClass){
        Game.getInstance().getComponentManager().registerComponent(ID, this, componentSubClass);
    }

    public static ArrayList<Class> getSubClasses() {
        return subClasses;
    }
}
