package model.map;

import java.util.ArrayList;

public class TectonAdjacency {
    private ArrayList<ArrayList<Integer>> tectonAdjacencyMatrix;

    public TectonAdjacency(int n){
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

    public void showAdjacencyMatrix(){
        for(int i = 0; i < tectonAdjacencyMatrix.size(); i++){
            for(int j = 0; j < tectonAdjacencyMatrix.get(i).size(); j++){
                System.out.print(tectonAdjacencyMatrix.get(i).get(j));
            }
            System.out.print("\n");
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
