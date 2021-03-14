package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class StageId extends Identity {

    private StageId(String id){
        super(id);
    }

    public StageId(){

    }

    public static StageId of(String id){

        return new StageId(id);
    }
}
