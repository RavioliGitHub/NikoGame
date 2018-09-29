package Controller;

import Default.Game;
import Systems.SystemManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;

public class Keyboard implements KeyListener {


    public Keyboard(){
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
            case KeyEvent.VK_E:
            case KeyEvent.VK_SPACE:
                Game.getInstance().getSystemManager().getKeyboardInputSystem().addToQueue2(event);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_CLEAR:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_ENTER:
                Game.getInstance().getSystemManager().getKeyboardInputSystem().addToQueue1(event);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
