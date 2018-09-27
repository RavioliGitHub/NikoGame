package View;

import java.awt.*;
import java.util.HashMap;

public class CompositeGraphic implements GraphicComponent {

    private HashMap<Point, GraphicComponent> childGraphics;

    public CompositeGraphic(GraphicComponent root){
        childGraphics = new HashMap<>();
        childGraphics.put(new Point(0,0),  root);
    }

    /**
     * @param child
     * @param x Relative to the root of the Composite
     * @param y Relative to the root of the Composite
     */
    public void add(GraphicComponent child, int x, int y){
        assert this != child;
        childGraphics.put(new Point(x,y), child);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        childGraphics.forEach((point, graphicComponent) -> {
            graphicComponent.draw(g, x + (int)point.getX(), y + (int)point.getY());
        });
    }

    @Override
    public GraphicComponent cloneGraphic() {
        CompositeGraphic clone = new CompositeGraphic(childGraphics.get(new Point(0,0)).cloneGraphic());
        childGraphics.forEach((point, graphicComponent) -> {
            if(point != new Point(0,0)) {
                GraphicComponent childClone = childGraphics.get(point).cloneGraphic();
                clone.childGraphics.put(point, childClone);
            }
        });
        return clone;
    }
}
