package Components;

public class VelocityComponent extends Component{
    private Direction direction;
    private double currentSpeed;
    private double defaultSpeedWhenMoving;
    private boolean moveAnimation1;
    private double moveStartTime;
    private boolean moveDoneOnPosition;

    public VelocityComponent(int ID, Direction direction, double currentSpeed, double defaultSpeedWhenMoving){
        super(ID, VelocityComponent.class);
        this.direction = direction;
        this.currentSpeed = currentSpeed;
        this.defaultSpeedWhenMoving = defaultSpeedWhenMoving;
        moveAnimation1 = true;
        moveStartTime = System.nanoTime();
        moveDoneOnPosition = false;
    }

    public void startMovement(Direction direction, double currentSpeed) {
        this.direction = direction;
        this.currentSpeed = currentSpeed;
        moveStartTime = System.nanoTime();
        moveDoneOnPosition = false;

    }

    /**
     * Speed = tiles per second
     * time for one tile (in seconds) = 1/speed
     * time for one tile (in nanoseconds) = (10^9) / speed
     *
     */
    public double movePercentage(){
        if (currentSpeed == 0){
            return 2;
        }
        double timeNeededForMove = Math.pow(10,9)/currentSpeed;
        double timeAlreadyPassed = System.nanoTime() - moveStartTime;
        double percentageOfTimePassed = timeAlreadyPassed/timeNeededForMove;

        return percentageOfTimePassed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getDefaultSpeedWhenMoving() {
        return defaultSpeedWhenMoving;
    }

    public boolean isMoveAnimation1() {
        return moveAnimation1;
    }

    public void invertMoveAnimation1() {
        moveAnimation1 = !moveAnimation1;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isMoveDoneOnPosition() {
        return moveDoneOnPosition;
    }

    public void moveDoneOnPosition(){
        moveDoneOnPosition = true;
    }
}
