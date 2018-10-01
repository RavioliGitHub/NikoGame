package View;

import Components.Direction;
import static Components.Direction.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public enum Images implements InGameImage {
    PLAYER1("player1.png", new Direction[]{DOWN,LEFT,RIGHT, UP}, true),
    DARK_ENEMY("enemy.png"),
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
     * Indicates where is which sprite in the image
     *
     * Example:
     * For the rugbyPlayer, the sprites are in this order
     * DOWN,LEFT,RIGHT,UP
     */
    private Direction[] directionOrder;

    private boolean walkingAnimation;

    Images(final String fileName){
        bufferedImage = getBufferedImageFromFileName(fileName);
        directionOrder = new Direction[]{LEFT,LEFT,LEFT,LEFT};
        walkingAnimation = false;
    }

    Images(final String fileName, final Direction[] directionOrder, boolean walkingAnimation){
        bufferedImage = getBufferedImageFromFileName(fileName);
        this.directionOrder = directionOrder;
        assert directionOrder.length == 4;
        //TODO assert contained are contained in 1 2 3 4
        this.walkingAnimation = walkingAnimation;
    }


    private BufferedImage getBufferedImageFromFileName(String fileName){
        try {
            return ImageIO.read(new File("Game/res/textures/" + fileName));
        } catch (IOException e) {
            System.out.println("Filename " + fileName);
            System.out.println("CWD:" + System.getProperty("user.dir"));
            e.printStackTrace();
        }
        throw new RuntimeException("Image could not be loaded");
    }

    public void draw(Graphics g, int x, int y) {
        BufferedImage image = bufferedImage.getSubimage(0,0,48,48);
        g.drawImage(image, x*48, y*48, 48, 48, null);
    }

    public void drawMoving(
        Graphics g, Direction direction, Direction directionOfMovement, boolean standing,
        boolean partOfMovement1, double percentageOfMovement,
        boolean moveDoneOnPosition,
        int x, int y){

        int partOfMovXIndex = 0;
        if(walkingAnimation) {
            if (!standing && percentageOfMovement > 0.2 && percentageOfMovement < 0.8) {
                partOfMovXIndex += 1;
            }
            if (!partOfMovement1) {
                partOfMovXIndex += 2;
            }
        }
        BufferedImage image = bufferedImage.getSubimage(
            partOfMovXIndex*48, java.util.Arrays.asList(directionOrder).indexOf(direction)*48, 48, 48);

        int offset = (int) (48*percentageOfMovement);
        x = x*48;
        y = y*48;
        switch (directionOfMovement){
            case UP:
                if(moveDoneOnPosition){y += 48;}
                y -= offset;
                break;

            case DOWN:
                if(moveDoneOnPosition){y -= 48;}
                y += offset;
                break;

            case RIGHT:
                if(moveDoneOnPosition){x -= 48;}
                x += offset;
                break;

            case LEFT:
                if(moveDoneOnPosition){x += 48;}
                x -= offset;
                break;

            default:
                throw new RuntimeException("Unknown direction");

        }
        g.drawImage(image, x, y, 48, 48, null);
    }

    @Override
    public InGameImage cloneGraphic() {
        return this;
    }

}
