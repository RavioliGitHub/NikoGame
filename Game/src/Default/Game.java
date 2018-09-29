package Default;

import Components.ComponentManager;
import Model.EntityManager;
import Model.EntityType;
import Systems.SystemManager;
import View.Window;

public class Game {

    private Window window;
    private EntityManager entityManager;
    private ComponentManager componentManager;
    private SystemManager systemManager;
    private boolean running;

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

        window = new Window(systemManager.getRenderingSystem());

        running = true;
    }

    public void gameLoop(){
        int a = 1;
        int b = 1;
        int c = 0;
        int d = 0;

        while(running){

            if(d < 40) {
                EntityType.values()[c % EntityType.values().length].create(a, b);
            }
            else {running = false;}

            a += 1;
            b += 1;
            c += 1;
            d += 1;


            systemManager.update();

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
