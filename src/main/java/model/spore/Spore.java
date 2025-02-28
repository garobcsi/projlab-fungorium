package model.spore;

import model.insect.Insect;

public class Spore {
    private int nutrition;

    public Spore(int n) {
        this.nutrition = n;
    }

    public void applyEffect(Insect insect){

    } // 📌 Minden spóra saját hatást alkalmaz

    public int getNutrition() {
        return nutrition;
    }
}
