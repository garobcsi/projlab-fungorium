package model.fungi;

import model.map.Tecton;
import model.player.FungusPlayer;

public class FungusBridge extends FungusThread {
    private FungusPlayer owner;
    private final Tecton targetTecton;

    public FungusBridge(FungusPlayer owner, Tecton host, Tecton target) {
        super(owner, host);
        this.owner = owner;
        this.targetTecton = target;
    }

    public Tecton getTargetTecton() {
        return targetTecton;
    }

    @Override
    public boolean equals(Object obj) {
        FungusBridge otherThread = (FungusBridge)obj;
        if((location == otherThread.getLocationTecton() && targetTecton == otherThread.getTargetTecton()) ||
                (location == otherThread.getTargetTecton() && targetTecton == otherThread.getLocationTecton())) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "FungusThread: " + location + " -> " + targetTecton;
    }
}
