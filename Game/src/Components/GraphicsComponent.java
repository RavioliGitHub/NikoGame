package Components;

import View.Images;

/**
 * Takes care of rendering
 */
public class GraphicsComponent extends Component {
    private Images image;

    public GraphicsComponent(int ID, Images image){
        super(ID, ComponentTypes.GRAPHICS);
        this.image = image;

    }


    public Images getImage() {
        return image;
    }

}
