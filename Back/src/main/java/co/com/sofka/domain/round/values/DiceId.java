package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class DiceId extends Identity {
    private DiceId(Integer id){
        super(id.toString());
    }

    public DiceId(){

    }

    public static DiceId of(Integer id){

        return new DiceId(id);
    }
}
