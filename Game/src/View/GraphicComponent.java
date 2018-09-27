package View;

import java.awt.*;

public interface GraphicComponent {
    void draw(Graphics g, int x, int y);
    GraphicComponent cloneGraphic();
}
