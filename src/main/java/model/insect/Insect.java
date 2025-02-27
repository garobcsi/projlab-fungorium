package model.insect;

import java.util.HashSet;

import model.map.Tecton;
import model.fungi.FungusThread;
import model.spore.Spore;

public class Insect {
    private Tecton location;
    private int consumedAmount;
    private String currentEffect;

    public void eatSpore(Spore s){
        consumedAmount += s.getNutrition();
        s.applyEffect(this);
    }

    //TODO: CHECK CODE
    public void move(Tecton t){
        //location.removeInsect(this);
        location = t;
        for(int i = 0; i < t.getSpores().size(); i++){
            eatSpore(t.getSpores().get(i));
        }
        t.addInsect(this);
    }

    public void cutThread(FungusThread thread){

    }

    public int getConsumedAmount(){
        return consumedAmount;
    }

    public void setCurrentEffect(String effect){
        currentEffect = effect;
    }
}
