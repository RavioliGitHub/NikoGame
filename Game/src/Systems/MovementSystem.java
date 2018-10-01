package Systems;

import Components.ComponentManager;
import Components.PositionComponent;
import Components.VelocityComponent;
import Default.Game;

import java.util.HashMap;

/**
 * Used the velocity and position component to make things move
 * Will later also use collision detection
 */
public class MovementSystem {


    public void update(){
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        HashMap<Integer, VelocityComponent> entityVelocityMap =
            componentManager.getComponentMap(VelocityComponent.class);

        HashMap<Integer, PositionComponent> entityPositionMap =
            componentManager.getComponentMap(PositionComponent.class);

        entityVelocityMap.forEach((ID, velocityComponent) -> {
            if(entityPositionMap.containsKey(ID)){
                //It is here assumed that everything has a position
                PositionComponent positionComponent = entityPositionMap.get(ID);
                adaptPosition(velocityComponent, positionComponent);
            }
        });
    }

    private void adaptPosition(VelocityComponent velocityComponent, PositionComponent positionComponent){
        if(velocityComponent.getCurrentSpeed() > 0) {
            //The move should only be done on the actual position when more than half the move is done
            if(velocityComponent.movePercentage() > 0.5 && !velocityComponent.isMoveDoneOnPosition()) {
                velocityComponent.moveDoneOnPosition();
                positionComponent.moveByOneTile(velocityComponent.getDirectionOfMovement());
            }
            //If the move is done
            if(velocityComponent.movePercentage() > 1) {
                //Set speed to 0
                velocityComponent.startMovement(velocityComponent.getDirectionOfMovement(), 0);
            }
        }

    }
}
