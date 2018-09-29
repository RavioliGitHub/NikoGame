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
    private int player1;

    private static Game instance;


    public static Game getInstance(){
        assert instance != null;
        return instance;
    }

    public static Game createInstance(){
        assert instance == null;
        instance = new Game();
        return instance;
    }

    private Game(){
        instance = this;

        entityManager = new EntityManager();
        componentManager = new ComponentManager();
        systemManager = new SystemManager();

        window = new Window(systemManager.getRenderingSystem());

        player1 = EntityType.PLAYER1.create(10,10);

        running = true;
    }

    /**
     while (true)
     {
     double start = getCurrentTime();
     processInput();
     update();
     render();

     sleep(start + MS_PER_FRAME - getCurrentTime());
     }
    */

     public void gameLoop(){
         testPreLoop();
        while(running){
            systemManager.update();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testPreLoop(){
        int ID  = EntityType.PLAYER1.create(2,2);
        EntityType.PLAYER1.testPlayerComponentCreation(ID);

        int ID2  = EntityType.BACKPACK.create(10,2);
        EntityType.PLAYER1.testBackPackComponentCreation2(ID2);

        int ID3 = EntityType.THIEF.create(10,10);
        EntityType.BACKPACK.testNinjaComponentCreationAZERTY(ID3);
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
