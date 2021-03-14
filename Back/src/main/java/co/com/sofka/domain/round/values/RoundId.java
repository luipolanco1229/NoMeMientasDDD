package co.com.sofka.domain.round.values;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.Identity;

public class RoundId extends Identity {


    private RoundId(String id){
        super(id);
    }

    public RoundId(){

    }

    public static RoundId of(String id){

        return new RoundId(id);
    }
}
