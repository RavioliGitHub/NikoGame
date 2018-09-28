package Components;

public class VelocityComponent extends Component{
    private int direction;
    private double speed;

    public VelocityComponent(int ID, int direction, double speed){
        super(ID, ComponentTypes.VELOCITY);
        this.direction = direction;
        this.speed = speed;
    }
}
