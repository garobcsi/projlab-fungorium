package model.game;

import model.fungi.FungusBridge;
import model.insect.Insect;
import model.map.Tecton;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Tecton> tectons;
    private List<Insect> insects;
    private ArrayList<ArrayList<Integer>> tectonAdjacencyMatrix;
    private ArrayList<FungusBridge> fungusBridges;

    public Map(int n){
        tectonAdjacencyMatrix = new ArrayList<>();
        fillAdjacencyMatrix(n, n);
    }

    public void fillAdjacencyMatrix(int n, int m){
        for(int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < m; j++){
                row.add(0);
            }
            tectonAdjacencyMatrix.add(row);
        }
    }

    public boolean checkTectonAdjacency(int n, int m){
        if(tectonAdjacencyMatrix.get(n).get(m) == 1){
            return true;
        }else{
            tectonAdjacencyMatrix.get(n).set(m, 1);
            tectonAdjacencyMatrix.get(m).set(n, 1);
            return false;
        }
    }
}
