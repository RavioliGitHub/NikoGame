package View;

import Default.Game;
import Default.Util;

import java.awt.*;
import java.time.LocalTime;
import java.util.LinkedList;

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

    public static void drawBackground(Graphics g){
        g.clearRect(0,0,Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
    }

    public static void drawTime(Graphics g, int x, int y){
        g.setFont(new Font("TimesRoman", Font.BOLD, 26));
        g.clearRect(x*48 + 1, (y-1)*48 + 1, 3*48 - 1, 1*48 - 1);

        LocalTime localTime = LocalTime.now();
        String hours = Integer.toString(localTime.getHour());
        String minutes = Integer.toString(localTime.getMinute());
        String seconds = Integer.toString(localTime.getSecond());

        String time = hours + " : " + minutes + " : " + seconds;

        g.drawString(time, x*48 + 5, y*48 - 10);
    }

    public static void drawFPS(Graphics g, int x, int y){
        g.setFont(new Font("TimesRoman", Font.BOLD, 26));
        g.clearRect(x*48 + 1, (y-1)*48 + 1, 2*48 - 1, 1*48 - 1);

        String FPS = Integer.toString(Game.getFPS()) +  " FPS";

        g.drawString(FPS, x*48 + 5, y*48 - 10);
    }

    public static void drawOutput(Graphics g, int x, int y){
        LinkedList<String> output = Util.getOutput();
        g.setFont(new Font("default", Font.BOLD, 28));

        for (int i = 0; i < Math.min(20, output.size()); i++){
            g.drawString(output.get(output.size()-1-i), x*48, (y+i)*48);
        }
    }
}
