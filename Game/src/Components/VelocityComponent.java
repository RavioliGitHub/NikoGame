package Components;

/**
 * Takes care of movement
 */
public class VelocityComponent extends Component{
    /**
     * Direction in which the movement is going
     */
    private Direction directionOfMovement;
    /**
     * Speed of the movement
     */
    private double currentSpeed;
    /**
     * Speed that will be used if no particular speed is needed
     * Eg, when walking, this will be used, could be double when running
     */
    private double defaultSpeedWhenMoving;
    /**
     * used for animation, so for a human eg the left and right leg switch
     */
    private boolean moveAnimation1;
    /**
     * When the move started (used for animation)
     */
    private double moveStartTime;
    /**
     * Whether the move has already be done regarding the positionComponent
     */
    private boolean moveDoneOnPosition;

    public VelocityComponent(int ID, Direction directionOfMovement, double currentSpeed, double defaultSpeedWhenMoving){
        super(ID, VelocityComponent.class);
        this.directionOfMovement = directionOfMovement;
        this.currentSpeed = currentSpeed;
        this.defaultSpeedWhenMoving = defaultSpeedWhenMoving;
        moveAnimation1 = true;
        moveStartTime = System.nanoTime();
        moveDoneOnPosition = false;
    }

    public void startMovement(Direction direction, double currentSpeed) {
        this.directionOfMovement = direction;
        this.currentSpeed = currentSpeed;
        moveStartTime = System.nanoTime();
        moveDoneOnPosition = false;
        moveAnimation1 = !moveAnimation1;

    }

    /**
     * For animation:
     * Tells how much of the move has already been done
     *
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

    public Direction getDirectionOfMovement() {
        return directionOfMovement;
    }

    public boolean isMoveDoneOnPosition() {
        return moveDoneOnPosition;
    }

    public void moveDoneOnPosition(){
        moveDoneOnPosition = true;
    }
}
