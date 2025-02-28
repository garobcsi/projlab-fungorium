package model.player;

import model.fungi.FungusSpecies;

public class FungusPlayer extends GeneralPlayer {
    private FungusSpecies species;

    public FungusPlayer(String name, FungusSpecies species) {
        super(name);
        this.species = species;
    }

    public void doAction() {

    }
}
