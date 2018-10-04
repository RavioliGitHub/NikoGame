package Components;

import Default.Game;

import java.util.ArrayList;

/**
 * Super class for components
 * Use to force behavior upon all components
 */
public abstract class Component{
    static {
        //Needs to happen before anything else happens
        initialiseSubclasses();
    }

    /**
     * All the different types components that exist
     */
    private static ArrayList<Class> subClasses;

    /**
     * Important, each new component need to be added here
     */
    private static void initialiseSubclasses(){
        subClasses = new ArrayList<>();
        subClasses.add(DirectionComponent.class);
        subClasses.add(GraphicsComponent.class);
        subClasses.add(KeyActionComponent.class);
        subClasses.add(PositionComponent.class);
        subClasses.add(VelocityComponent.class);
        subClasses.add(QuickFixComponent.class);
    }


    /**
     * Ensures that they all are constructed with an ID and the correct component type
     * @param ID Entity ID
     * @param componentSubClass Subclass
     */
    public Component(int ID, Class componentSubClass){
        Game.getInstance().getComponentManager().registerComponent(ID, this, componentSubClass);
    }

    static ArrayList<Class> getSubClasses() {
        return subClasses;
    }
}
