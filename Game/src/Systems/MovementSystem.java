package Systems;

import Components.ComponentManager;
import Components.ComponentTypes;
import Components.PositionComponent;
import Components.VelocityComponent;
import Default.Game;

import java.util.HashMap;

public class MovementSystem {


    public void update(){
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        HashMap<Integer, VelocityComponent> entityVelocityMap =
            componentManager.getComponentMap(ComponentTypes.VELOCITY);

        HashMap<Integer, PositionComponent> entityPositionMap =
            componentManager.getComponentMap(ComponentTypes.POSITION);

        entityVelocityMap.forEach((ID, velocityComponent) -> {
            if(entityPositionMap.containsKey(ID)){
                PositionComponent positionComponent = entityPositionMap.get(ID);
                adaptPosition(velocityComponent, positionComponent);
            }
        });
    }

    private void adaptPosition(VelocityComponent velocityComponent, PositionComponent positionComponent){
        if(velocityComponent.getCurrentSpeed() > 0) {
            switch (velocityComponent.getDirection()) {
                case 0:
                    //TODO remember, increase by 1 is only a tempory value to test
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
                    throw new RuntimeException("Invalide direction" + velocityComponent.getDirection());
            }
        }
        velocityComponent.setCurrentSpeed(0);
    }
}
