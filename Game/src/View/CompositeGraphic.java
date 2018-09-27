package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CompositeGraphic implements Graphic {

    private HashMap<Point, Graphic> childGraphics;

    public CompositeGraphic(Graphic root){
        childGraphics = new HashMap<>();
        childGraphics.put(new Point(0,0),  root);
    }

    /**
     * @param child
     * @param x Relative to the root of the Composite
     * @param y Relative to the root of the Composite
     */
    public void add(Graphic child, int x, int y){
        assert this != child;
        childGraphics.put(new Point(x,y), child);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        childGraphics.forEach((point, graphic) -> {
            graphic.draw(g, x + (int)point.getX(), y + (int)point.getY());
        });
    }

    @Override
    public Graphic cloneGraphic() {
        CompositeGraphic clone = new CompositeGraphic(childGraphics.get(new Point(0,0)).cloneGraphic());
        childGraphics.forEach((point, graphic) -> {
            if(point != new Point(0,0)) {
                Graphic childClone = childGraphics.get(point).cloneGraphic();
                clone.childGraphics.put(point, childClone);
            }
        });
        return clone;
    }
}
