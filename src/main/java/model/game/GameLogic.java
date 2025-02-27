package model.game;

import model.insect.Insect;
import model.map.Tecton;
import model.player.GeneralPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private List<GeneralPlayer> players;

    private int roundNumber = 0;

    public void play(){
        int hanyadik = 0;
        for (int i = 0; i < 100; i++){
//            for (int j = 0; j < players.size(); j++){
//              players.get(j).action();
//            }
            if (hanyadik == (players.size()))
                hanyadik = 0;
            players.get(hanyadik).action();
            hanyadik++;
        }
    }

    /*
    public void turns(int currentTurn){
        while (){

        }
    }
     */

}
