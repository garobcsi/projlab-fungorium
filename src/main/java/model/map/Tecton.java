package model.map;

import java.util.ArrayList;

import model.fungi.Fungus;
import model.fungi.FungusThread;
import model.insect.Insect;
import model.spore.Spore;
import model.help.Tuple;

import java.util.List;

public abstract class Tecton {
    private static int incrementer = 0;
    private int tecton_id;
    private List<FungusThread> fungusBridges;
    private boolean hasFungus;
    private List<Insect> insects;
    private List<Spore> spores;
    private Fungus fungus;

    public Tecton(){
        tecton_id = incrementer++;
        fungusBridges = new ArrayList<>();
        insects = new ArrayList<>();
        spores = new ArrayList<>();
        hasFungus = false;
    }
    public void addFungus(Fungus f) {
        this.fungus = f;
        hasFungus = true;
    }


    public int getTectonId() {
        return tecton_id;
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

    public void growFungusBridge(Tecton other, TectonAdjacency adjMatrix){
        if(!adjMatrix.checkTectonAdjacency(tecton_id, other.tecton_id)){
            FungusThread newBridge = new FungusThread(this, other);
            fungusBridges.add(newBridge);
            other.fungusBridges.add(newBridge);
            System.out.println("A tektonok össze lettek kötve!");
        }else{
            System.out.println("A tektonok már össze vannak kötve!");
        }
    }

    public void getListSize(){
        System.out.println(fungusBridges.size());
    }

    public List<FungusThread> getFungusBridges() {
        return fungusBridges;
    }

    public boolean searchForFungus() {
        //TODO
        return false;
    }
    public void removeFungusBridge(FungusThread fungusThread) {
        fungusBridges.removeIf(ft -> ft.equals(fungusThread));
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
    public void clearSpores() {
        spores.clear();
    }

    public List<Spore> getSpores(){
        return spores;
    }
}
