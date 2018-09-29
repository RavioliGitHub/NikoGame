package Systems;

import Components.ComponentManager;
import Components.ComponentTypes;
import Components.GraphicsComponent;
import Components.PositionComponent;
import Controller.Keyboard;
import Default.Game;
import View.Drawing;
import View.Images;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderingSystem extends JPanel {

    public RenderingSystem(Keyboard keyboard) {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(keyboard);
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<Integer> entities = Game.getInstance().getEntityManager().getEntities();
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        Drawing.drawBackground(g);
        Drawing.drawGrid(g);
        Drawing.drawCoordinatesOnEveryTile(g);
        Drawing.drawTime(g);

        for (int ID : entities){
            if (componentManager.contains(ID, ComponentTypes.GRAPHICS)&&
                componentManager.contains(ID, ComponentTypes.POSITION)){
                GraphicsComponent graphicsComponent =
                    (GraphicsComponent) componentManager.getComponent(ID, ComponentTypes.GRAPHICS);
                PositionComponent positionComponent =
                    (PositionComponent) componentManager.getComponent(ID, ComponentTypes.POSITION);

                Images image = graphicsComponent.getImage();
                int x = positionComponent.getX();
                int y = positionComponent.getY();

                image.draw(g, x, y);
            }
        }
    }
}
