package Systems;

import Components.ComponentManager;
import Components.ComponentTypes;
import Components.GraphicsComponent;
import Components.PositionComponent;
import Default.Game;
import View.Images;

import java.awt.*;
import java.util.ArrayList;

public class RenderingSystem extends Systems{


    @Override
    void update(Graphics g) {
        ArrayList<Integer> entities = Game.getInstance().getEntityManager().getEntities();
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        for (int ID : entities){
            if (componentManager.contains(ID, ComponentTypes.GRAPHICS)&&
                componentManager.contains(ID, ComponentTypes.POSITION)){
                GraphicsComponent graphicsComponent =
                    (GraphicsComponent) componentManager.getComponent(ID, ComponentTypes.GRAPHICS);
                PositionComponent positionComponent =
                    (PositionComponent) componentManager.getComponent(ID, ComponentTypes.GRAPHICS);

                Images image = graphicsComponent.getImage();
                int x = positionComponent.getX();
                int y = positionComponent.getY();

                image.draw(g, x, y);
            }
        }
    }
}
