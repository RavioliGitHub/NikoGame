package Default;
import View.Window;

/**
 * Main class
 * Currently only opens the window and starts the game loop
 *
 * Future plans, integrate a menu so you can switch between games
 */

public class Main {
    public static void main(String[] args){

        //Opens the window
        new Window(Game.createInstance().getSystemManager().getRenderingSystem());
        //Starts the game loop
        Game.getInstance().gameLoop();

    }
}
