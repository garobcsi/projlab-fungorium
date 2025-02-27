package model.map;

import java.util.ArrayList;

import model.fungi.FungusThread;
import model.insect.Insect;
import model.spore.Spore;
import model.help.Tuple;

import java.util.List;

public abstract class Tecton {
    private List<FungusThread> fungusBridges;
    private boolean hasFungus;
    private List<Insect> insects;
    private List<Spore> spores;
    private List<Tuple<String,Tecton>> neighbors;

    public Tecton(){
        fungusBridges = new ArrayList<>();
        insects = new ArrayList<>();
        spores = new ArrayList<>();
        hasFungus = false;
    }

    // ✅ Már nem kell getter, mert az objektum maga dönti el, hogy hozzáadható-e
    public void addFungusThread(Tecton other) {
        if (this == other) {
            System.out.println("❌ Hiba: Nem lehet fonalat létrehozni önmagára! " + this);
            return;
        }

        // Már létezik fonal? Akkor nem csinálunk semmit.
        for (FungusThread ft : fungusBridges) {
            if ((ft.getHostTecton() == this && ft.getTargetTecton() == other) ||
                    (ft.getHostTecton() == other && ft.getTargetTecton() == this)) {
                System.out.println("❌ Már létezik fonal " + this + " és " + other + " között.");
                return;
            }
        }

        // Ha nincs még fonal, létrehozzuk és rögtön hozzáadjuk mindkét tektonhoz.
        FungusThread thread = new FungusThread(this, other);
        fungusBridges.add(thread);
        other.fungusBridges.add(thread);
        System.out.println("✅ Fonal létrejött: " + thread);
    }

    public List<FungusThread> getFungusBridges() {
        return fungusBridges;
    }

    public boolean searchForFungus() {
        //TODO
        return false;
    }
    public void removeThread(FungusThread fungusThread) {
        //TODO
    }

    public void addSpores(List<Spore> sp){
        spores.addAll(sp);
    }

    public void addInsect(Insect insect){
        insects.add(insect);
    }

    public void removeInsect(Insect insect){
        insects.remove(insect);
    }

    public void killInsect() {
        //TODO
    }

    public List<Spore> getSpores(){
        return spores;
    }
}
