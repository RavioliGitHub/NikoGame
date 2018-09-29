package View;

import Default.Game;
import Systems.RenderingSystem;

import java.awt.Color;

import javax.swing.*;

public class Window {

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;

    public Window(RenderingSystem renderingSystem) {
        JFrame window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.getContentPane().setBackground(Color.gray);
        window.getContentPane().add(renderingSystem);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
