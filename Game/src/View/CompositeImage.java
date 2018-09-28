package View;

import java.awt.*;
import java.util.HashMap;

public class CompositeImage implements ImageCompositeInterface {

    private HashMap<Point, ImageCompositeInterface> childGraphics;

    public CompositeImage(ImageCompositeInterface root){
        childGraphics = new HashMap<>();
        childGraphics.put(new Point(0,0),  root);
    }

    /**
     * @param child
     * @param x Relative to the root of the Composite
     * @param y Relative to the root of the Composite
     */
    public void add(ImageCompositeInterface child, int x, int y){
        assert this != child;
        childGraphics.put(new Point(x,y), child);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        childGraphics.forEach((point, imageCompositeInterface) -> {
            imageCompositeInterface.draw(g, x + (int)point.getX(), y + (int)point.getY());
        });
    }

    @Override
    public ImageCompositeInterface cloneGraphic() {
        CompositeImage clone = new CompositeImage(childGraphics.get(new Point(0,0)).cloneGraphic());
        childGraphics.forEach((point, imageCompositeInterface) -> {
            if(point != new Point(0,0)) {
                ImageCompositeInterface childClone = childGraphics.get(point).cloneGraphic();
                clone.childGraphics.put(point, childClone);
            }
        });
        return clone;
    }
}
