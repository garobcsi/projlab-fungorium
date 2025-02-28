package model.game;

import model.player.GeneralPlayer;
import java.util.List;

public class GameHandler {
    private final List<GeneralPlayer> players;
    private static int roundNumber = 0;

    public GameHandler(List<GeneralPlayer> players) {
        this.players = players;
    }

    public void play(){
        int hanyadik = 0;
        for (int i = 0; i < 100; i++){
            if (hanyadik == (players.size()))
                hanyadik = 0;
            players.get(hanyadik).doAction();
            hanyadik++;
        }
    }

    public void nextRound(int count){

    }

    public void nextPlayer(){

    }
}
