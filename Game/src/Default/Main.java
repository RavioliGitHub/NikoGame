package Default;

import java.awt.im.*;
import java.awt.im.InputContext;

public class Main {
    public static void main(String[] args){
        Game.createInstance().gameLoop();
        InputContext context = InputContext.getInstance();
        System.out.println(context.getLocale().toString());
    }
}
