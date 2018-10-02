package Systems;

import Controller.Keyboard;
import Controller.Mouse;

public class SystemManager {
    private RenderingSystem renderingSystem;
    private KeyboardInputSystem keyboardInputSystem;
    private MovementSystem movementSystem;
    private MouseInputSystem mouseInputSystem;

    public SystemManager(){
        renderingSystem = new RenderingSystem(new Keyboard(), new Mouse());
        keyboardInputSystem = new KeyboardInputSystem();
        movementSystem = new MovementSystem();
        mouseInputSystem = new MouseInputSystem();
    }

    public void update(){
        keyboardInputSystem.update();
        mouseInputSystem.update();
        movementSystem.update();
        renderingSystem.repaint();
    }

    public RenderingSystem getRenderingSystem() {
        return renderingSystem;
    }

    public KeyboardInputSystem getKeyboardInputSystem() {
        return keyboardInputSystem;
    }

    public MouseInputSystem getMouseInputSystem() {
        return mouseInputSystem;
    }
}
