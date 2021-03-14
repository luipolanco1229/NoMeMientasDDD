package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class GameId extends Identity {

    private GameId(String id){
        super(id);
    }

    public GameId(){

    }

    public static GameId of(String id){
        return new GameId(id);
    }
}
