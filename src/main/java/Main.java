import model.fungi.CommonFungus;
import model.fungi.Fungus;
import model.insect.Insect;
import model.map.*;
import model.player.FungusPlayer;

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
        FungusPlayer fungusPlayer1 = new FungusPlayer();
        dTecton.growFungusBridge(fungusPlayer1,sTecton, tectonMatrix);
        sTecton.growFungusBridge(fungusPlayer1, dTecton, tectonMatrix);
        sTecton.growFungusBridge(fungusPlayer1, tTecton, tectonMatrix);
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
