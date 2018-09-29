package Systems;

import java.awt.*;

public class SystemManager {
    private RenderingSystem renderingSystem;

    public SystemManager(){
        renderingSystem = new RenderingSystem();
    }

    public void update(){
        renderingSystem.repaint();

    }


    public RenderingSystem getRenderingSystem() {
        return renderingSystem;
    }
}
