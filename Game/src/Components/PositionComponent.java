package Components;

/**
 * Tell where something is
 */
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

    public void moveByOneTile(Direction direction){
        switch (direction) {
            case RIGHT:
                x += 1;
                break;
            case UP:
                y -= 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case DOWN:
                y += 1;
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != PositionComponent.class && obj.getClass() != Component.class) {return false;}

        return ((PositionComponent)obj).x == x && ((PositionComponent)obj).y == y;
    }
}
