package Components;

public class VelocityComponent extends Component{
    private int direction;
    private double currentSpeed;
    private double maxSpeed;

    public VelocityComponent(int ID, int direction, double currentSpeed, double maxSpeed){
        super(ID, ComponentTypes.VELOCITY);
        this.direction = direction;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
