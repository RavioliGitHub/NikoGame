package View;

import java.awt.*;

public class Drawing {
    public static void drawGrid(Graphics g){
        for (int x = 0; x < Window.WINDOW_WIDTH; x += 48){
            g.drawLine(x,0,x,Window.WINDOW_HEIGHT);
        }
        for (int y = 0; y < Window.WINDOW_HEIGHT; y+= 48){
            g.drawLine(0,y,Window.WINDOW_WIDTH,y);
        }
    }

    public static void drawCoordinatesOnTheEdge(Graphics g){
        g.setFont(new Font("TimesRoman", Font.BOLD, 24));
        for (int x = 0; x < Window.WINDOW_WIDTH; x += 48){
            int a = x/48;
            g.drawString(Integer.toString(a), x+12, 30);
        }
        for (int y = 0; y < Window.WINDOW_HEIGHT; y+= 48){
            int b = y/48;
            g.drawString(Integer.toString(b), 10, y+24);
        }
    }

    public static void drawCoordinatesOnEveryTile(Graphics g){
        g.setFont(new Font("TimesRoman", Font.BOLD, 12));
        for (int x = 0; x < Window.WINDOW_WIDTH; x += 48){
            for (int y = 0; y < Window.WINDOW_HEIGHT; y+= 48){
                int a = x/48;
                int b = y/48;
                String coordinates = "(" + a + "," + b + ")";
                g.drawString(coordinates, x+3, y+24);
            }
        }
    }
}
