package Controller;

import Components.DirectionComponent;
import Components.VelocityComponent;
import Default.Game;

public enum Action {
    MOVE_UP{
        @Override
        public void execute(int ID){
            move(ID, DirectionComponent.UP);
        }
    },
    MOVE_DOWN {
        @Override
        public void execute(int ID) {
            move(ID, DirectionComponent.DOWN);
        }
    },
    MOVE_LEFT {
        @Override
        public void execute(int ID) {
            move(ID, DirectionComponent.LEFT);
        }
    },
    MOVE_RIGHT {
        @Override
        public void execute(int ID) {
            move(ID, DirectionComponent.RIGHT);
        }
    },
    ATTACK {
        @Override
        public void execute(int ID) {

        }
    };

    public abstract void execute(int ID);

    private static void move(int ID, int direction){
        VelocityComponent velocityComponent =
            (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, VelocityComponent.class);

        if (velocityComponent.movePercentage() > 0.8) {

            velocityComponent.startMovement(direction, velocityComponent.getMaxSpeed());

            if (Game.getInstance().getComponentManager().contains(ID, DirectionComponent.class)) {
                DirectionComponent directionComponent =
                    (DirectionComponent) Game.getInstance().getComponentManager().getComponent(ID, DirectionComponent.class);
                directionComponent.setDirection(direction);
            }
        }
    }
}
