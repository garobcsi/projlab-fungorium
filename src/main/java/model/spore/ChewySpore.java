package model.spore;

import model.insect.Insect;

public class ChewySpore extends Spore {
    public ChewySpore(int n) {
        super(n);
    }

    @Override
    public void applyEffect(Insect insect) {
        //insect.disableCutting(2); // 📌 2 körig nem tud fonalat elvágni
    }
}
