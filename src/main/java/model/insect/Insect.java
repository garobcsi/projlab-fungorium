package model.insect;

import model.map.Tecton;
import model.fungi.FungusBridge;
import model.map.TectonAdjacency;
import model.spore.Spore;

import java.util.List;

public class Insect {
    public int getNutrition() {
        return nutrition;
    }

    private int nutrition;
    private boolean isParalyzed;
    private int extraMoves;
    private int delayedTurns;
    private int cuttingDisabledTurns;
    private Tecton currentTecton;

    public Insect(Tecton startingTecton) {
        this.nutrition = 0;
        this.isParalyzed = false;
        this.extraMoves = 0;
        this.delayedTurns = 0;
        this.cuttingDisabledTurns = 0;
        this.currentTecton = startingTecton;
    }

    // 📌 Megpróbál átlépni egy másik tektonra, de csak ha van fonal közöttük
    public void move(Tecton targetTecton, TectonAdjacency adjacencyMatrix) {
        if (isParalyzed) {
            System.out.println("⛔ A rovar megbénult, nem tud mozogni!");
            return;
        }

        if (adjacencyMatrix.checkTectonAdjacency(currentTecton.getTectonId(), targetTecton.getTectonId())) {
            System.out.println("🐜 A rovar átlépett " + currentTecton + " -> " + targetTecton);
            currentTecton = targetTecton;
            consumeSpores(); // 📌 Amint átlép, automatikusan megeszi az ott lévő spórákat
        } else {
            System.out.println("❌ Nincs fonal, nem lehet mozogni " + currentTecton + " -> " + targetTecton);
        }
    }

    // 📌 A rovar automatikusan megeszi az összes spórát a jelenlegi tektonon
    private void consumeSpores() {
        List<Spore> spores = currentTecton.getSpores();
        if (spores.isEmpty()) {
            System.out.println("🍂 Nincs spóra ezen a tektonon: " + currentTecton);
            return;
        }

        System.out.println("🍄 A rovar spórákat talált és megeszi őket!");
        for (Spore spore : spores) {
            consumeSpore(spore);
        }
        currentTecton.clearSpores();
    }
     // 📌 Az összes spóra elfogyasztása után töröljük őket a tektonról
    public void cutThread(FungusBridge thread, TectonAdjacency adjMatrix){
        adjMatrix.modifyAdjacencyMatrix(thread.getHostTecton().getTectonId(),
                thread.getTargetTecton().getTectonId());
        thread.getHostTecton().removeFungusBridge(thread);
        thread.getTargetTecton().removeFungusBridge(thread);
    }

    // 📌 A rovar elfogyaszt egy adott spórát, amely automatikusan alkalmazza a hatását
    private void consumeSpore(Spore spore) {
        System.out.println("🍄 A rovar megevett egy spórát: " + spore.getClass().getSimpleName());
        this.nutrition += spore.getNutrition();
        spore.applyEffect(this);
    }
}
