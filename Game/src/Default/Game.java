package Default;

import Components.ComponentManager;
import Model.EntityManager;
import Systems.SystemManager;

public class Game {
    private static Game instance;

    private EntityManager entityManager;
    private ComponentManager componentManager;
    private SystemManager systemManager;

    private boolean running;


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

        gameLoop();
    }

    private void gameLoop(){

        while(running){

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }




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
