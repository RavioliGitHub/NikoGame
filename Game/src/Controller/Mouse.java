package Controller;

import Model.EntityType;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e);
        EntityType.BREAKABLE_BLOCK.create((int)((double)e.getX()/48.0),(int)((double)e.getY()/48.0));

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e);
        //EntityType.BREAKABLE_BLOCK.create((int)((double)e.getX()/48.0),(int)((double)e.getY()/48.0));

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
