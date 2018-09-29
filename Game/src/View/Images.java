package View;

import Components.DirectionComponent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum Images implements ImageCompositeInterface {
    PLAYER1("player1.png", new int[]{2,3,1,0}, true),
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

    private boolean walkingAnimation;

    Images(final String fileName){
        bufferedImage = getBufferedImageFromFileName(fileName);
        directionOrder = new int[]{0,0,0,0};
        walkingAnimation = false;
    }

    Images(final String fileName, final int[] directionOrder, boolean walkingAnimation){
        bufferedImage = getBufferedImageFromFileName(fileName);
        this.directionOrder = directionOrder;
        assert directionOrder.length == 4;
        //TODO assert contained are contained in 1 2 3 4
        this.walkingAnimation = walkingAnimation;
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

    public void drawMoving(
            Graphics g, int direction, int directionOfMovement, boolean standing,
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
            partOfMovXIndex*48, directionOrder[direction]*48, 48, 48);

        int offset = (int) (48*percentageOfMovement);
        x = x*48;
        y = y*48;
        switch (directionOfMovement){
            case DirectionComponent.UP:
                if(moveDoneOnPosition){y += 48;}
                y -= offset;
                break;

            case DirectionComponent.DOWN:
                if(moveDoneOnPosition){y -= 48;}
                y += offset;
                break;

            case DirectionComponent.RIGHT:
                if(moveDoneOnPosition){x -= 48;}
                x += offset;
                break;

            case DirectionComponent.LEFT:
                if(moveDoneOnPosition){x += 48;}
                x -= offset;
                break;

            default:
                throw new RuntimeException("Unknown direction");

        }
        g.drawImage(image, x, y, 48, 48, null);
    }

    @Override
    public ImageCompositeInterface cloneGraphic() {
        return this;
    }

}
