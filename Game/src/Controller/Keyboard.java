package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public Keyboard(){

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:

            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:


            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
            case KeyEvent.VK_CLEAR:

            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_SPACE:

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
