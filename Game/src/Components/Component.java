package Components;

import Default.Game;

public abstract class Component{
    public Component(int ID, ComponentTypes componentType){
        Game.getInstance().getComponentManager().registerComponent(ID, this, componentType);
    }
}
