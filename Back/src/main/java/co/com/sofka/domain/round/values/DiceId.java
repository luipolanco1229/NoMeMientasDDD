package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class DiceId extends Identity {
    private DiceId(String id){
        super(id);
    }

    public DiceId(){

    }

    public static DiceId of(String id){

        return new DiceId(id);
    }
}
