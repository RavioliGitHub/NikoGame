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
    }
}
