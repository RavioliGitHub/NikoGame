package Systems;

import Components.*;
import Controller.Keyboard;
import Controller.Mouse;
import Default.Game;
import View.Drawing;
import View.Images;
import View.InGameImage;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Draws all on the screen
 */
public class RenderingSystem extends JPanel {

    public RenderingSystem(Keyboard keyboard, Mouse mouse) {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(keyboard);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<Integer> entities = Game.getInstance().getEntityManager().getEntities();
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        Drawing.drawBackground(g);
        Drawing.drawGrid(g);
        Drawing.drawCoordinatesOnEveryTile(g);
        Drawing.drawTime(g);
        Drawing.drawFPS(g, 30, 5);
        Drawing.drawOutput(1, g, 30, 7);
        Drawing.drawOutput(2, g, 25, 7);
        Drawing.drawOutput(3, g, 20, 7);

        for (int ID : (ArrayList<Integer>)entities.clone()){
            //If it has a graphic and a position
            if (componentManager.contains(ID, GraphicsComponent.class)&&
                componentManager.contains(ID, PositionComponent.class)){
                GraphicsComponent graphicsComponent =
                    (GraphicsComponent) componentManager.getComponent(ID, GraphicsComponent.class);
                PositionComponent positionComponent =
                    (PositionComponent) componentManager.getComponent(ID, PositionComponent.class);

                InGameImage image = graphicsComponent.getImage();
                int x = positionComponent.getX();
                int y = positionComponent.getY();

                //Standard values that will be replaced if others exists
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
                        directionOfMov = velocityComponent.getDirectionOfMovement();
                    }
                }
                image.drawMoving(g,direction, directionOfMov,standing, movementSprite1, partOfMovement, moveDoneOnPosition, x, y);
            }
        }
    }
}
