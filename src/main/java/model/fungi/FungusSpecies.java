package model.fungi;

import model.map.Tecton;

import java.util.ArrayList;
import java.util.List;

public class FungusSpecies {
    List<Fungus> gombaTests;
    List<FungusThread> fungusThreads;
    
    public FungusSpecies(){
        gombaTests = new ArrayList<>();
        fungusThreads = new ArrayList<>();
    }

    public void playerSpreadSpore(Fungus fg, Tecton selectedTecton){
        for(Fungus f : this.gombaTests){
            if (fg == f){
                fg.disperseSpore(selectedTecton);
            }
        }
    }
}
