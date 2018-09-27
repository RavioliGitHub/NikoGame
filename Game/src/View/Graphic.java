package View;

import java.awt.*;

public interface Graphic {
    void draw(Graphics g, int x, int y);
    Graphic cloneGraphic();
}
