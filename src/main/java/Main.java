import model.fungi.FungusThread;
import model.map.Desert;
import model.map.Swamp;
import model.map.Tecton;
import model.map.Tundra;

public class Main {
    public static void main(String[] args) {
        Desert dTecton = new Desert();
        Swamp sTecton = new Swamp();
        Tundra tTecton = new Tundra();

        // ✅ Csak egy fonalat szabad létrehozni!
        dTecton.addFungusThread(sTecton);
        dTecton.addFungusThread(tTecton);
        sTecton.addFungusThread(dTecton); // ❌ Ez

        System.out.println(dTecton.getFungusBridges());

        // Kiírjuk az eredmény
    }
}
