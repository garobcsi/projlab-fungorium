import model.fungi.CommonFungus;
import model.fungi.Fungus;
import model.insect.Insect;
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
        dTecton.growFungusBridge(sTecton, tectonMatrix);
        sTecton.growFungusBridge(dTecton, tectonMatrix);
        sTecton.growFungusBridge(tTecton, tectonMatrix);
        tectonMatrix.showAdjacencyMatrix();
        Insect insect1 = new Insect(dTecton);
        Fungus fungus1 = new CommonFungus();
        dTecton.addFungus(fungus1);
        fungus1.produceSpore();
        fungus1.produceSpore();
        fungus1.produceSpore();
        fungus1.disperseSpore(sTecton);
        insect1.move(sTecton, tectonMatrix);
        insect1.move(sTecton, tectonMatrix);
        System.out.println(insect1.getNutrition());
        dTecton.getListSize();
        sTecton.getListSize();
        tTecton.getListSize();
    }
}
