package Components;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public Direction getOpposite(){
        switch (this){
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case DOWN: return UP;
            case UP: return DOWN;
        }
        throw new RuntimeException("not a direction");
    }
}
