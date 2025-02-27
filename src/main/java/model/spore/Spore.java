package model.spore;

import model.insect.Insect;

public class Spore {
    private int nutrition;

    public Spore(int n){
        nutrition = n;
    }

    public void applyEffect(Insect insect) {
        //alosztályok valósítják meg
    }

    public int getNutrition() {
        return nutrition;
    }
    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }
}
