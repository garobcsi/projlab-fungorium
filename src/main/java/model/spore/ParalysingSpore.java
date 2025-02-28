package model.spore;

import model.insect.Insect;

public class ParalysingSpore extends Spore {
    public ParalysingSpore(int n) {
        super(n);
    }

    @Override
    public void applyEffect(Insect insect) {
        //insect.paralyze(3); // 📌 A rovar 3 körre megbénul
    }
}
