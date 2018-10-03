package Components;

public class QuickFixComponent extends Component {

    private boolean crossable;
    private boolean draggable;

    public QuickFixComponent(int ID) {
        super(ID, QuickFixComponent.class);
        crossable = true;
        draggable = false;
    }

    public boolean isCrossable() {
        return crossable;
    }

    public void setCrossable(boolean crossable) {
        this.crossable = crossable;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }


}
