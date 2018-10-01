package Systems;

import Controller.Keyboard;


/**
 * See ECS for details
 * Handles the order in which the systems update
 */
public class SystemManager {
    private RenderingSystem renderingSystem;
    private KeyboardInputSystem keyboardInputSystem;
    private MovementSystem movementSystem;

    public SystemManager(){
        renderingSystem = new RenderingSystem(new Keyboard());
        keyboardInputSystem = new KeyboardInputSystem();
        movementSystem = new MovementSystem();
    }

    public void update(){
        keyboardInputSystem.update();
        movementSystem.update();
        renderingSystem.repaint();
    }

    public RenderingSystem getRenderingSystem() {
        return renderingSystem;
    }

    public KeyboardInputSystem getKeyboardInputSystem() {
        return keyboardInputSystem;
    }
}
