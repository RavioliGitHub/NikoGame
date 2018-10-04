package Systems;

import Components.ComponentManager;
import Components.PositionComponent;
import Components.QuickFixComponent;
import Components.VelocityComponent;
import Default.Game;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

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

        HashMap<Integer, QuickFixComponent> quickFixComponentMap =
            componentManager.getComponentMap(QuickFixComponent.class);

        entityVelocityMap.forEach((ID, velocityComponent) -> {
            if(entityPositionMap.containsKey(ID)){
                PositionComponent positionComponent = entityPositionMap.get(ID);

                if(quickFixComponentMap.containsKey(ID)){
                    QuickFixComponent quickFixComponent = quickFixComponentMap.get(ID);
                    adaptPosition(velocityComponent, positionComponent, quickFixComponent, ID);
                }
                else {
                    adaptPosition(velocityComponent, positionComponent);
                }
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

    private void adaptPosition(VelocityComponent velocityComponent,
                               PositionComponent positionComponent,
                               QuickFixComponent quickFixComponent,
                               int ID){

        if(velocityComponent.getCurrentSpeed() > 0) {
            //If there has not been a move yet and the way cant be crossed
            if(!velocityComponent.isMoveDoneOnPosition() && !crossable(velocityComponent,positionComponent,quickFixComponent,ID)){
                velocityComponent.startMovement(velocityComponent.getDirectionOfMovement(),0);
            }

            //Else if the move has already been halfway done
            //The move should only be done on the actual position when more than half the move is done
            else if(velocityComponent.movePercentage() > 0.5 && !velocityComponent.isMoveDoneOnPosition()) {
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

    private boolean crossable(VelocityComponent velocityComponent,
                              PositionComponent positionComponent,
                              QuickFixComponent quickFixComponent,
                              int ID){
        if(quickFixComponent.isCrossable()){return true;}

        AtomicBoolean canCross = new AtomicBoolean(true);

        ComponentManager componentManager = Game.getInstance().getComponentManager();

        HashMap<Integer, PositionComponent> entityPositionMap =
            componentManager.getComponentMap(PositionComponent.class);

        HashMap<Integer, QuickFixComponent> quickFixComponentMap =
            componentManager.getComponentMap(QuickFixComponent.class);

        HashMap<Integer, VelocityComponent> entityVelocityMap =
            componentManager.getComponentMap(VelocityComponent.class);


        //Move it to see where it will be
        positionComponent.moveByOneTile(velocityComponent.getDirectionOfMovement());
        entityPositionMap.forEach((loopID, loopPositionComponent) -> {
            if(loopPositionComponent.equals(positionComponent) && loopID != ID){
                if(quickFixComponentMap.containsKey(loopID)){
                    QuickFixComponent otherQuickFixComponent = quickFixComponentMap.get(loopID);
                    if (!otherQuickFixComponent.isCrossable()){
                        canCross.set(false);
                        return;
                    }
                }
            }
        });
        positionComponent.moveByOneTile(velocityComponent.getDirectionOfMovement().getOpposite());
        return canCross.get();
    }
}
