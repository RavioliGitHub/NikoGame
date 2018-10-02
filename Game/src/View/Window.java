package View;

import Systems.RenderingSystem;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;

    public Window(RenderingSystem renderingSystem) {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        getContentPane().setBackground(Color.gray);
        getContentPane().add(renderingSystem);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
