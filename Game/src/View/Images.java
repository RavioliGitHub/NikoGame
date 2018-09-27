package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public enum Images implements Graphic{
    PLAYER1("player1.png", new int[]{2,3,1,0}),
    DARK_ENNEMY("enemy.png"),
    THIEF("thiefenemy.png"),


    HEARTHBAR("hearthBar.png"),
    BACKPACK("backpack.png"),
    HEALPOTION("healpotion.png"),
    WEAPON("weapon.png"),

    TRAPDOOR("trapdoor.png"),
    GROUND("ground.jpg"),

    BREAKABLE_BLOCK("breakableblock.png"),
    UNBREAKABLE_BLOCK("unbreakableblock.jpg");

    private BufferedImage bufferedImage;

    /**
     * Indicates which part of the image contains the wanted direction
     * Array containing 4 ints
     *
     * The int at position i indicates which part of the image has to be taken for direction i
     * Example: For the player1.png, the order is down, left, right, up
     * Therefore, to have the sprite going up, i need the 4rth row
     * So the array will be {2,3,1,0}
     * directionOrder[up] = directionOrder[1] = 3
     * The image at 3*48 is the 4rth image
     *
     * If no direction images are available, defaults to {0,0,0,0}
     */
    private int[] directionOrder;

    Images(final String fileName){
        bufferedImage = getBufferedImageFromFileName(fileName);
        directionOrder = new int[]{0,0,0,0};
    }

    Images(final String fileName, final int[] directionOrder){
        bufferedImage = getBufferedImageFromFileName(fileName);
        this.directionOrder = directionOrder;
        assert directionOrder.length == 4;
        //TODO assert contained are contained in 1 2 3 4
    }


    private BufferedImage getBufferedImageFromFileName(String fileName){
        try {
            return ImageIO.read(Images.class.getResource("/textures/" + fileName));
        } catch (IOException e) {
            System.out.println("Filename " + fileName);
            e.printStackTrace();
        }
        throw new RuntimeException("Image could not be loaded");
    }

    public void draw(Graphics g, int x, int y) {
        BufferedImage image = bufferedImage.getSubimage(0,0,48,48);
        g.drawImage(image, x*48, y*48, 48, 48, null);
    }

    public void drawMoving(Graphics g, int direction, int partOfMovement, int x, int y){
        BufferedImage image = bufferedImage.getSubimage(partOfMovement*48, directionOrder[direction]*48, 48, 48);
        g.drawImage(image, x*48, y*48, 48, 48, null);
    }

    @Override
    public Graphic cloneGraphic() {
        return this;
    }

}
