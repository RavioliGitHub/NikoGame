package Default;

import Components.ComponentManager;
import Model.EntityManager;
import Systems.SystemManager;

public class Game {
    private static Game instance;
    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Game(){
        entityManager = new EntityManager();
        componentManager = new ComponentManager();
        systemManager = new SystemManager();
    }

    private EntityManager entityManager;
    private ComponentManager componentManager;
    private SystemManager systemManager;


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ComponentManager getComponentManager() {
        return componentManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }


}
