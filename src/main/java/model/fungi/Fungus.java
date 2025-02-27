package model.fungi;

import java.util.List;
import java.util.ArrayList;

import model.map.Tecton;
import java.util.Random;

import model.random.RandomSingleton;
import model.spore.Spore;

public abstract class Fungus{
    private int health; // élet
    private Tecton location; // hely
    private int maxSpores;
    private List<Spore> producedSpores;

    public Fungus(){
        producedSpores = new ArrayList<Spore>();
    }

    public void produceSpore(){
//        Random rand = new Random();
        RandomSingleton rs = RandomSingleton.getInstance();

        int randomNutrition = rs.nextInt(11);
        System.out.println(randomNutrition);
        producedSpores.add(new Spore(randomNutrition));
    }

    public void disperseSpore(Tecton t){
        t.addSpores(producedSpores);
    }
}
