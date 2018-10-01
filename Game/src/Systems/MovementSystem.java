package Systems;

import Components.ComponentManager;
import Components.PositionComponent;
import Components.VelocityComponent;
import Default.Game;

import java.util.HashMap;

public class MovementSystem {


    public void update(){
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        HashMap<Integer, VelocityComponent> entityVelocityMap =
            componentManager.getComponentMap(VelocityComponent.class);

        HashMap<Integer, PositionComponent> entityPositionMap =
            componentManager.getComponentMap(PositionComponent.class);

        entityVelocityMap.forEach((ID, velocityComponent) -> {
            if(entityPositionMap.containsKey(ID)){
                PositionComponent positionComponent = entityPositionMap.get(ID);
                adaptPosition(velocityComponent, positionComponent);
            }
        });
    }

    private void adaptPosition(VelocityComponent velocityComponent, PositionComponent positionComponent){
        if(velocityComponent.getCurrentSpeed() > 0) {
            if(velocityComponent.movePercentage() > 0.5 && !velocityComponent.isMoveDoneOnPosition()) {
                velocityComponent.moveDoneOnPosition();
                switch (velocityComponent.getDirection()) {
                    case 0:
                        positionComponent.increaseX(1);
                        break;
                    case 1:
                        positionComponent.increaseY(-1);
                        break;
                    case 2:
                        positionComponent.increaseX(-1);
                        break;
                    case 3:
                        positionComponent.increaseY(1);
                        break;
                    default:
                        throw new RuntimeException("Invalid direction" + velocityComponent.getDirection());
                }
            }
            if(velocityComponent.movePercentage() > 1) {
                velocityComponent.startMovement(velocityComponent.getDirection(), 0);
                velocityComponent.invertMoveAnimation1();
            }
        }

    }
}
