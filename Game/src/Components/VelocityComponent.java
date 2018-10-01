package Components;

public class VelocityComponent extends Component{
    private int direction;
    private double currentSpeed;
    private double maxSpeed;
    private boolean moveAnimation1;
    private double moveStartTime;
    private boolean moveDoneOnPosition;

    public VelocityComponent(int ID, int direction, double currentSpeed, double maxSpeed){
        super(ID, VelocityComponent.class);
        this.direction = direction;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        moveAnimation1 = true;
        moveStartTime = System.nanoTime();
        moveDoneOnPosition = false;
    }

    public void startMovement(int direction, double currentSpeed) {
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

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isMoveAnimation1() {
        return moveAnimation1;
    }

    public void invertMoveAnimation1() {
        moveAnimation1 = !moveAnimation1;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isMoveDoneOnPosition() {
        return moveDoneOnPosition;
    }

    public void moveDoneOnPosition(){
        moveDoneOnPosition = true;
    }
}
