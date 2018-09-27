package View;

import Model.GameObject;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class Window {

    private Map map = new Map();

    public Window() {
        JFrame window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.getContentPane().setBackground(Color.gray);
        window.getContentPane().add(this.map);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void update(){
        map.repaint();
    }
}
