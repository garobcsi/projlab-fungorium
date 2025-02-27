package model.spore;

import model.insect.Insect;

public class ParalysingSpore extends Spore {
    public ParalysingSpore(int n){
        super(n);
    }

    public void applyEffect(Insect insect) {
        insect.setCurrentEffect("Paralyzed");
    }
}
