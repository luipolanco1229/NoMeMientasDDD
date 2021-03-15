package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.ValueObject;

public class Face implements ValueObject<Integer> {
    private Integer value;

    public Face (Integer value){
        if (value > 0 && value<7)
        this.value = value;
    }
    @Override
    public Integer value(){
        return value;
    }
}
