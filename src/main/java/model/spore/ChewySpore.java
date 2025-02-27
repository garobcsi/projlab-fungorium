package model.spore;

import model.insect.Insect;

public class ChewySpore extends Spore {
    public ChewySpore(int n){
        super(n);
    }

    public void applyEffect(Insect insect) {
        insect.setCurrentEffect("Chewy");
    }
}
