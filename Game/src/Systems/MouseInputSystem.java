package Systems;

import Model.EntityType;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

public class MouseInputSystem {
    private Queue<MouseEvent> mouseEventQueue;

    int previousX = 0;
    int previousY = 0;

    public MouseInputSystem(){
        mouseEventQueue = new LinkedList<>();
    }

    public void update(){
        MouseEvent mouseEvent;
        while((mouseEvent = mouseEventQueue.poll()) != null){
            reactToMouseEvent(mouseEvent);
        }
    }

    private void reactToMouseEvent(MouseEvent mouseEvent){
        int x = (int)((double)mouseEvent.getX()/48.0);
        int y = (int)((double)mouseEvent.getY()/48.0);

        if(!(x == previousX && y == previousY)){
            EntityType.BACKPACK.testBackPackComponentCreation2(EntityType.BREAKABLE_BLOCK.create(x,y));
            previousX = x;
            previousY = y;
        }
    }


    public void addToMouseEventQueue(MouseEvent mouseEvent){
        mouseEventQueue.add(mouseEvent);
    }
}
