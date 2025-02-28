package model.fungi;

import model.map.Tecton;
import model.player.FungusPlayer;

public class FungusThread {
    protected FungusPlayer owner;
    protected Tecton location;

    public FungusThread(FungusPlayer fungusOwner, Tecton fungusLocation){
        owner = fungusOwner;
        location = fungusLocation;
    }

    public Tecton getLocationTecton(){
        return location;
    }
}
