package View;

import javax.swing.*;
import java.awt.*;

import static View.Images.*;

public class Map extends JPanel {

    private static final long serialVersionUID = 1L;


    public Map() {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void drawGrid(Graphics g){
        for (int x = 0; x < Window.WINDOW_WIDTH; x += 48){
            g.drawLine(x,0,x,Window.WINDOW_HEIGHT);
        }
        for (int y = 0; y < Window.WINDOW_HEIGHT; y+= 48){
            g.drawLine(0,y,Window.WINDOW_WIDTH,y);
        }
    }

    public void drawCoordinatesOnTheEdge(Graphics g){
        g.drawString("yo", 480, 480);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        for (int x = 0; x < Window.WINDOW_WIDTH; x += 48){
            g.drawString(Integer.toString(x), (x*48)+24, 24);
        }
        for (int y = 0; y < Window.WINDOW_HEIGHT; y+= 48){
            g.drawString(Integer.toString(y), 24, (y*48)+24);
        }
    }

    public void paint(Graphics g){
        PLAYER1.draw(g,0,0);
        PLAYER1.draw(g, 10, 10);
        PLAYER1.drawMoving(g, 2,2,12,12);
        DARK_ENEMY.drawMoving(g, 1, 0, 13,2);

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

        GraphicComponent clone = circle.cloneGraphic();
        circle.add(clone, 3,3);
        circle.add(clone,6,6);
        circle.add(clone,9,9);
        circle.add(clone,12,6);
        circle.add(clone,15,9);

        circle.draw(g,2,2);

        drawGrid(g);
        drawCoordinatesOnTheEdge(g);
    }
}
