package model.fungi;

import model.map.Tecton;

import java.util.ArrayList;
import java.util.List;

public class FungusSpecies {
    private String speciesName;
    List<Fungus> gombaTests;
    List<FungusThread> fungusThreads;
    
    public FungusSpecies(String fungusSpeciesName){
        speciesName = fungusSpeciesName;
        gombaTests = new ArrayList<>();
        fungusThreads = new ArrayList<>();
    }
}
