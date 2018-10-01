package View;

import Components.Direction;

import java.awt.*;

public interface InGameImage {
    void draw(Graphics g, int x, int y);
    InGameImage cloneGraphic();
    void drawMoving(
        Graphics g, Direction direction, Direction directionOfMovement, boolean standing,
        boolean partOfMovement1, double percentageOfMovement,
        boolean moveDoneOnPosition,
        int x, int y);
}
