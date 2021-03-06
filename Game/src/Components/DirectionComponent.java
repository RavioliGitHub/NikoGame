package Components;

/**
 * Handles in which direction something is looking
 * ! Do not confuse with the movement direction
 */
public class DirectionComponent extends Component {

    /**
     * The direction FACED, not the one moved to
     * Relevant for sidesteps
     */
    private Direction direction;

    public DirectionComponent(int ID, Direction direction) {
        super(ID, DirectionComponent.class);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
