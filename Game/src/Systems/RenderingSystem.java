package Systems;

import Components.*;
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

                int direction = 0;
                int directionOfMov = 0;
                double partOfMovement = 0;
                boolean standing = true;
                boolean movementSprite1 = true;
                boolean moveDoneOnPosition = false;

                if (componentManager.contains(ID, ComponentTypes.DIRECTION)){
                    DirectionComponent directionComponent =
                        (DirectionComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.DIRECTION);
                    direction = directionComponent.getDirection();
                }

                if (componentManager.contains(ID, ComponentTypes.VELOCITY)) {
                    VelocityComponent velocityComponent =
                        (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.VELOCITY);
                    if (velocityComponent.getCurrentSpeed() > 0) {
                        standing = false;
                        movementSprite1 = velocityComponent.isMoveAnimation1();
                        partOfMovement = velocityComponent.movePercentage();
                        moveDoneOnPosition = velocityComponent.isMoveDoneOnPosition();
                        directionOfMov = velocityComponent.getDirection();
                    }
                }
                image.drawMoving(g,direction, directionOfMov,standing, movementSprite1, partOfMovement, moveDoneOnPosition, x, y);
            }
        }
    }
}
