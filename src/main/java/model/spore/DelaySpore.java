package model.spore;

import model.insect.Insect;

public class DelaySpore extends Spore {
    public DelaySpore(int n) {
        super(n);
    }

    @Override
    public void applyEffect(Insect insect) {
        //insect.delayNextAction();
    }
}
