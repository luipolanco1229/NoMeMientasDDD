package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.ValueObject;

public class Face implements ValueObject<Integer> {
    private final Integer value;

    public Face (Integer value) {
        if (value > 0 && value < 7) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Cantidad no apta como valor de un dado");
        }
    }


    public Integer value(){
        return value;
    }

}


