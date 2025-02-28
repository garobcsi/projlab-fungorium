package model.map;

import java.util.ArrayList;

import model.fungi.Fungus;
import model.fungi.FungusBridge;
import model.insect.Insect;
import model.player.FungusPlayer;
import model.spore.Spore;

import java.util.List;

public abstract class Tecton {
    private static int incrementer = 0;
    private int tecton_id;
    private List<FungusBridge> fungusBridges;
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

    public void growFungusBridge(FungusPlayer owner, Tecton other, TectonAdjacency adjMatrix){
        if(!adjMatrix.checkTectonAdjacency(tecton_id, other.tecton_id)){
            FungusBridge newBridge = new FungusBridge(owner, this, other);
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

    public List<FungusBridge> getFungusBridges() {
        return fungusBridges;
    }

    public boolean searchForFungus() {
        //TODO
        return false;
    }
    public void removeFungusBridge(FungusBridge fungusThread) {
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
