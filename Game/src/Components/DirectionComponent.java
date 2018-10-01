package Components;

public class DirectionComponent extends Component {

    public static final int RIGHT = 0;
    public static final int UP = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;

    private int direction;

    public DirectionComponent(int ID, int direction) {
        super(ID, DirectionComponent.class);
        this.direction = direction;
        assert direction <= 3 && direction >= 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        assert direction <= 3 && direction >= 0;
        this.direction = direction;
    }
}
