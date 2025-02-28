package model.game;

import model.fungi.FungusBridge;
import model.insect.Insect;
import model.map.Tecton;
import model.map.TectonAdjacency;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Tecton> tectons;
    private TectonAdjacency tectonAdjacencyMatrix;

    public Map(int n){
        tectonAdjacencyMatrix = new TectonAdjacency(n);
    }
}
