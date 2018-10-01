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
            if (componentManager.contains(ID, GraphicsComponent.class)&&
                componentManager.contains(ID, PositionComponent.class)){
                GraphicsComponent graphicsComponent =
                    (GraphicsComponent) componentManager.getComponent(ID, GraphicsComponent.class);
                PositionComponent positionComponent =
                    (PositionComponent) componentManager.getComponent(ID, PositionComponent.class);

                Images image = graphicsComponent.getImage();
                int x = positionComponent.getX();
                int y = positionComponent.getY();

                Direction direction = Direction.LEFT;
                Direction directionOfMov = Direction.LEFT;
                double partOfMovement = 0;
                boolean standing = true;
                boolean movementSprite1 = true;
                boolean moveDoneOnPosition = false;

                if (componentManager.contains(ID, DirectionComponent.class)){
                    DirectionComponent directionComponent =
                        (DirectionComponent) Game.getInstance().getComponentManager().getComponent(ID, DirectionComponent.class);
                    direction = directionComponent.getDirection();
                }

                if (componentManager.contains(ID, VelocityComponent.class)) {
                    VelocityComponent velocityComponent =
                        (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, VelocityComponent.class);
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
