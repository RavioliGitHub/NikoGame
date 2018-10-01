package Components;

import View.Images;
import View.InGameImage;

/**
 * Takes care of rendering
 */
public class GraphicsComponent extends Component {

    /**
     * Image which will be used to represent the entity
     */
    private InGameImage image;

    public GraphicsComponent(int ID, Images image){
        super(ID, GraphicsComponent.class);
        this.image = image;
    }

    public InGameImage getImage() {
        return image;
    }

}
