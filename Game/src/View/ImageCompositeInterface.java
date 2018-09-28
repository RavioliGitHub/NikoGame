package View;

import java.awt.*;

public interface ImageCompositeInterface {
    void draw(Graphics g, int x, int y);
    ImageCompositeInterface cloneGraphic();
}
