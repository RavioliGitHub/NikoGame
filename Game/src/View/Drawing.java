package View;

import Components.PositionComponent;
import Components.QuickFixComponent;
import Default.Game;
import Default.Util;

import java.awt.*;
import java.time.LocalTime;
import java.util.LinkedList;

public class Drawing {
    static int DEFAULT_TIME_X = 30;
    static int DEFAULT_TIME_Y = 3;
    static Integer timeID;
    static Integer FPSID;
    static Integer outputID;
    static Integer output2ID;
    static Integer output3ID;

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

    public static void drawTime(Graphics g){
        if (timeID == null){
            Util.println("created time comps");
            timeID = Game.getInstance().getEntityManager().createEntity("time");
            new QuickFixComponent(timeID).setDraggable(true);
            new PositionComponent(timeID, DEFAULT_TIME_X, DEFAULT_TIME_Y);
        }

        int width = 3;
        g.setFont(new Font("TimesRoman", Font.BOLD, 26));

        PositionComponent positionComponent =
            (PositionComponent) Game.getInstance().getComponentManager().getComponent(timeID, PositionComponent.class);
        int x = positionComponent.getX();
        int y = positionComponent.getY()+1;

        g.clearRect(x*48 + 1, (y-1)*48 + 1, width*48 - 1, 1*48 - 1);

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

    public static void drawOutput(int outputNumber, Graphics g, int x, int y){
        LinkedList<String> output;
        if(outputNumber == 1){output = Util.getOutput();}
        else if(outputNumber == 2){output = Util.getOutput2();}
        else if(outputNumber == 3){output = Util.getOutput3();}
        else {throw new RuntimeException("invalid output number");}
        g.setFont(new Font("default", Font.BOLD, 28));

        for (int i = 0; i < Math.min(10, output.size()); i++){
            g.drawString(output.get(output.size()-1-i), x*48, (y+i)*48);
        }
    }
}
