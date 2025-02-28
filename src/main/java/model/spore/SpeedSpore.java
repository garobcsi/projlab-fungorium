package model.spore;

import model.insect.Insect;

public class SpeedSpore extends Spore {
    public SpeedSpore(int n) {
        super(n);
    }

    @Override
    public void applyEffect(Insect insect) {
        //insect.gainExtraMove();
    }
}
