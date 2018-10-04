package Systems;

import Components.ComponentManager;
import Components.PositionComponent;
import Components.QuickFixComponent;
import Components.VelocityComponent;
import Default.Game;
import Model.EntityType;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static java.awt.event.MouseEvent.*;

public class MouseInputSystem {

    private LinkedList<Integer> pressedButtons;
    private Queue<MouseEvent> mouseEventQueue;
    private PositionComponent mousePosition;

    PositionComponent dragged = null;
    int previousX = 0;
    int previousY = 0;

    public MouseInputSystem(){
        pressedButtons = new LinkedList<>();
        mouseEventQueue = new LinkedList<>();
        mousePosition = new PositionComponent(0,100,100);
    }


    public void update(){
        MouseEvent mouseEvent;
        while((mouseEvent = mouseEventQueue.poll()) != null){
            reactToMouseEvent(mouseEvent);
        }
    }

    private void reactToMouseEvent(MouseEvent mouseEvent){
        setMousePositionToEventPosition(mouseEvent);
        switch (mouseEvent.getID()){
            case MOUSE_PRESSED:
                System.out.println(mouseEvent.getButton());
                if(!pressedButtons.contains(mouseEvent.getButton())){
                    pressedButtons.add(mouseEvent.getButton());
                }
                break;
            case MOUSE_RELEASED:
                pressedButtons.remove((Integer)mouseEvent.getButton());
                dragged = null;
                break;
            case MOUSE_CLICKED:
                break;
            case MOUSE_MOVED:
                break;
            case MOUSE_DRAGGED:
                reactToMouseDragged(mouseEvent);
                break;
            case MOUSE_WHEEL:
                break;
            case MOUSE_ENTERED:
                break;
            case MOUSE_EXITED:
                break;
            default:
                throw new RuntimeException("Unknown MouseEvent type");
        }
    }

    private void reactToMouseDragged(MouseEvent mouseEvent){
        System.out.println(mouseEvent.getButton());
        if (dragged == null) {
            attemptToFindDraggable();
        } else {
            dragged.setX(mousePosition.getX());
            dragged.setY(mousePosition.getY());
        }
    }

    private void attemptToFindDraggable(){
        ComponentManager componentManager = Game.getInstance().getComponentManager();

        HashMap<Integer, PositionComponent> entityPositionMap =
            componentManager.getComponentMap(PositionComponent.class);

        HashMap<Integer, QuickFixComponent> quickFixComponentMap =
            componentManager.getComponentMap(QuickFixComponent.class);

        for(Map.Entry<Integer, PositionComponent> positionPair : entityPositionMap.entrySet()){
            //If there is an entity there that is not the mouse
            if (positionPair.getValue().equals(mousePosition) && positionPair.getValue() != mousePosition){
                //And it has a quickfix component
                if (quickFixComponentMap.containsKey(positionPair.getKey())){
                    //And it is draggable
                    if (quickFixComponentMap.get(positionPair.getKey()).isDraggable()){
                        dragged = positionPair.getValue();
                    }
                }
            }
        }
    }

    private int toCoord(int x){
        return (int)(((double)x)/48.0);
    }

    private void setMousePositionToEventPosition(MouseEvent mouseEvent){
        mousePosition.setX(toCoord(mouseEvent.getX()));
        mousePosition.setY(toCoord(mouseEvent.getY()));
    }


    public void addToMouseEventQueue(MouseEvent mouseEvent){
        mouseEventQueue.add(mouseEvent);
    }
}
