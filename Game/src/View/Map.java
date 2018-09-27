package View;

import Model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static View.Images.*;

public class Map extends JPanel {

    private static final long serialVersionUID = 1L;


    public Map() {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void paint(Graphics g){
        PLAYER1.draw(g,0,0);
        PLAYER1.draw(g, 10, 10);
        PLAYER1.drawMoving(g, 2,2,12,12);
        DARK_ENNEMY.drawMoving(g, 1, 0, 13,2);

        CompositeGraphic circle = new CompositeGraphic(BREAKABLE_BLOCK);
        circle.add(BREAKABLE_BLOCK,0,1);
        circle.add(BREAKABLE_BLOCK,0,2);
        circle.add(BREAKABLE_BLOCK,0,3);

        circle.add(BREAKABLE_BLOCK,1,0);
        circle.add(BREAKABLE_BLOCK,2,0);
        circle.add(BREAKABLE_BLOCK,3,0);

        circle.add(BREAKABLE_BLOCK, 3,1);
        circle.add(BREAKABLE_BLOCK, 3,2);

        circle.add(BREAKABLE_BLOCK, 1,3);
        circle.add(BREAKABLE_BLOCK, 2,3);

        circle.add(BREAKABLE_BLOCK, 3,3);

        Graphic clone = circle.cloneGraphic();
        circle.add(clone, 3,3);
        circle.add(clone,6,6);
        circle.add(clone,9,9);
        circle.add(clone,12,6);
        circle.add(clone,15,9);

        circle.draw(g,2,2);
    }
}
