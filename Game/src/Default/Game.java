package Default;

import Components.ComponentManager;
import Model.EntityManager;
import Model.EntityType;
import Systems.SystemManager;

public class Game {

    private EntityManager entityManager;
    private ComponentManager componentManager;
    private SystemManager systemManager;
    private boolean running;
    private int player1;

    private static int FPS;

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
         //initialisation value to avoid bugs on the first FPS calculation
         double startTime = System.currentTimeMillis()-1000;
        while(running){

            /*
            Part that calculates FPS
            */
            double loopTime = System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            FPS = (int)(1000.0/loopTime);
            //Approximation so the FPS doesnt flicker too much
            if(FPS >= 57 && FPS <= 63){FPS = 60;}
            /*
            End of FPS part
             */
            systemManager.update();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testPreLoop(){
        int ID2  = EntityType.BACKPACK.create(10,2);
        EntityType.PLAYER1.testBackPackComponentCreation2(ID2);

        int ID3 = EntityType.THIEF.create(10,10);
        EntityType.BACKPACK.testNinjaComponentCreationAZERTY(ID3);

        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(2, 2));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(4, 4));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(4, 2));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(2, 4));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(5, 5));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 5));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(5, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(5, 2));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(5, 3));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(5, 4));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 4));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 3));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 2));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(1, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(2, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(3, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(4, 1));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(2, 5));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(3, 5));
        EntityType.PLAYER1.testPlayerComponentCreation(EntityType.PLAYER1.create(4, 5));
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

    public static int getFPS() {
        return FPS;
    }
}
