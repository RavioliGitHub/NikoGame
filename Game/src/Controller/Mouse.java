package Controller;

import Default.Game;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Game.getInstance().getSystemManager().getMouseInputSystem().addToMouseEventQueue(e);
    }
}
