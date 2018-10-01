package View;

import Components.Direction;

import java.awt.*;
import java.util.HashMap;

public class CompositeImage implements InGameImage {

    private HashMap<Point, InGameImage> childGraphics;

    public CompositeImage(InGameImage root){
        childGraphics = new HashMap<>();
        childGraphics.put(new Point(0,0),  root);
    }

    /**
     * @param child
     * @param x Relative to the root of the Composite
     * @param y Relative to the root of the Composite
     */
    public void add(InGameImage child, int x, int y){
        assert this != child;
        childGraphics.put(new Point(x,y), child);
    }

    @Override
    public InGameImage cloneGraphic() {
        CompositeImage clone = new CompositeImage(childGraphics.get(new Point(0,0)).cloneGraphic());
        childGraphics.forEach((point, inGameImage) -> {
            if(point != new Point(0,0)) {
                InGameImage childClone = childGraphics.get(point).cloneGraphic();
                clone.childGraphics.put(point, childClone);
            }
        });
        return clone;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        childGraphics.forEach((point, inGameImage) -> {
            inGameImage.draw(g, x + (int)point.getX(), y + (int)point.getY());
        });
    }

    @Override
    public void drawMoving(Graphics g, Direction direction, Direction directionOfMovement, boolean standing, boolean partOfMovement1, double percentageOfMovement, boolean moveDoneOnPosition, int x, int y) {
        childGraphics.forEach((point, inGameImage) -> {
            inGameImage.drawMoving(g,direction,directionOfMovement,standing,partOfMovement1,percentageOfMovement,moveDoneOnPosition,x,y);
        });
    }
}
