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
    public boolean equals(Object obj) {
        FungusThread otherThread = (FungusThread)obj;
        if((hostTecton == otherThread.getHostTecton() && targetTecton == otherThread.getTargetTecton()) ||
                (hostTecton == otherThread.getTargetTecton() && targetTecton == otherThread.getHostTecton())) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "FungusThread: " + hostTecton + " -> " + targetTecton;
    }
}
