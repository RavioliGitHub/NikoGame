package Controller;

import Default.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    public Keyboard(){
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Game.getInstance().getSystemManager().getKeyboardInputSystem().addToPressedKeys(event);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Game.getInstance().getSystemManager().getKeyboardInputSystem().removeFromPressedKeys(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}