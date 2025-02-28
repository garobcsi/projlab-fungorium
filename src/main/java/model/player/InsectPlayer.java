package model.player;

import model.insect.Insect;

public class InsectPlayer extends GeneralPlayer {
    private Insect insect;

    public InsectPlayer(String name, Insect insect) {
        super(name);
        this.insect = insect;
    }

    public void doAction() {

    }
}
