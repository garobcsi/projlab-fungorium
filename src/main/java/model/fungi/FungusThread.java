package model.fungi;

import model.help.Tuple;
import model.map.Tecton;

public class FungusThread {
    private final Tecton hostTecton;
    private final Tecton targetTecton;

    public FungusThread(Tecton host, Tecton target) {
        this.hostTecton = host;
        this.targetTecton = target;
    }

    public Tecton getHostTecton() {
        return hostTecton;
    }

    public Tecton getTargetTecton() {
        return targetTecton;
    }

    @Override
    public String toString() {
        return "FungusThread: " + hostTecton + " -> " + targetTecton;
    }
}
