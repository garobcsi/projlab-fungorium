import model.fungi.FungusThread;
import model.map.*;

public class Main {
    public static void main(String[] args) {
        /*
        Desert dTecton = new Desert();
        Swamp sTecton = new Swamp();
        Tundra tTecton = new Tundra();

        // ✅ Csak egy fonalat szabad létrehozni!
        dTecton.addFungusThread(sTecton);
        dTecton.addFungusThread(tTecton);
        sTecton.addFungusThread(dTecton); // ❌ Ez

        System.out.println(dTecton.getFungusBridges());

        // Kiírjuk az eredmény
        */

        TectonAdjacency tectonMatrix = new TectonAdjacency(5);
        Desert dTecton = new Desert();
        Swamp sTecton = new Swamp();
        Tundra tTecton = new Tundra();
        tectonMatrix.showAdjacencyMatrix();
        dTecton.growFungusBridge(sTecton, tectonMatrix);
        tectonMatrix.showAdjacencyMatrix();
        sTecton.growFungusBridge(dTecton, tectonMatrix);
        sTecton.growFungusBridge(tTecton, tectonMatrix);
        tectonMatrix.showAdjacencyMatrix();
    }
}
