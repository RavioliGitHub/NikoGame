package Components;

public class PositionComponent extends Component{
    private int x;
    private int y;

    public PositionComponent(int ID, int x, int y){
        super(ID, PositionComponent.class);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increaseX(int change){
        x = x + change;
    }

    public void increaseY(int change){
        y = y + change;
    }
}
