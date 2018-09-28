package Components;

public class PositionComponent extends Component{
    private int x;
    private int y;

    public PositionComponent(int ID, int x, int y){
        super(ID, ComponentTypes.POSITION);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
