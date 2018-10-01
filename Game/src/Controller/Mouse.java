package Controller;

import Components.*;
import Default.Game;
import Model.EntityType;
import View.Images;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Mouse implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());

        int x = (int)((double)e.getX()/48.0);
        int y = (int)((double)e.getY()/48.0);
        int ID = Game.getInstance().getEntityManager().createEntity("mousClicLocation");
        new PositionComponent(ID, x, y);
        new GraphicsComponent(ID, Images.DARK_ENEMY);

        HashMap<Integer, Action> keyEventActionHashMap = new HashMap<>();
        keyEventActionHashMap.put(KeyEvent.VK_W, Action.MOVE_UP);
        keyEventActionHashMap.put(KeyEvent.VK_S, Action.MOVE_DOWN);
        keyEventActionHashMap.put(KeyEvent.VK_D, Action.MOVE_RIGHT);
        keyEventActionHashMap.put(KeyEvent.VK_A, Action.MOVE_LEFT);

        new KeyActionComponent(ID, keyEventActionHashMap);

        new VelocityComponent(ID, Direction.UP, 0, 2);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
