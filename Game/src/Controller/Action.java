package Controller;

import Components.ComponentTypes;
import Components.VelocityComponent;
import Default.Game;

public enum Action {
    MOVE_UP{
        @Override
        public void execute(int ID){
            VelocityComponent velocityComponent =
                (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.VELOCITY);

            velocityComponent.setDirection(1);
            velocityComponent.setCurrentSpeed(velocityComponent.getMaxSpeed());
        }
    },
    MOVE_DOWN {
        @Override
        public void execute(int ID) {
            VelocityComponent velocityComponent =
                (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.VELOCITY);

            velocityComponent.setDirection(3);
            velocityComponent.setCurrentSpeed(velocityComponent.getMaxSpeed());
        }
    },
    MOVE_LEFT {
        @Override
        public void execute(int ID) {
            VelocityComponent velocityComponent =
                (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.VELOCITY);

            velocityComponent.setDirection(2);
            velocityComponent.setCurrentSpeed(velocityComponent.getMaxSpeed());
        }
    },
    MOVE_RIGHT {
        @Override
        public void execute(int ID) {
            VelocityComponent velocityComponent =
                (VelocityComponent) Game.getInstance().getComponentManager().getComponent(ID, ComponentTypes.VELOCITY);

            velocityComponent.setDirection(0);
            velocityComponent.setCurrentSpeed(velocityComponent.getMaxSpeed());
        }
    },
    ATTACK {
        @Override
        public void execute(int ID) {

        }
    };

    public abstract void execute(int ID);
}
