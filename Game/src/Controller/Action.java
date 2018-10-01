package Controller;

import Components.Direction;
import Components.DirectionComponent;
import Components.VelocityComponent;
import Default.Game;

public enum Action {
    MOVE_UP{
        @Override
        public void execute(int ID){
            move(ID, Direction.UP);
        }
    },
    MOVE_DOWN {
        @Override
        public void execute(int ID) {
            move(ID, Direction.DOWN);
        }
    },
    MOVE_LEFT {
        @Override
        public void execute(int ID) {
            move(ID, Direction.LEFT);
        }
    },
    MOVE_RIGHT {
        @Override
        public void execute(int ID) {
            move(ID, Direction.RIGHT);
        }
    },
    ATTACK {
        @Override
        public void execute(int ID) {

        }
    };

    public abstract void execute(int ID);

    private static void move(int ID, Direction direction){
        VelocityComponent velocityComponent =
            (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, VelocityComponent.class);

        if (velocityComponent.movePercentage() > 0.8) {

            velocityComponent.startMovement(direction, velocityComponent.getDefaultSpeedWhenMoving());

            if (Game.getInstance().getComponentManager().contains(ID, DirectionComponent.class)) {
                DirectionComponent directionComponent =
                    (DirectionComponent) Game.getInstance().getComponentManager().getComponent(ID, DirectionComponent.class);
                directionComponent.setDirection(direction);
            }
        }
    }
}
