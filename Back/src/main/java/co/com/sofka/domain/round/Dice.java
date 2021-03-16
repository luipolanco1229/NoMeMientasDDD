package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.round.values.DiceId;
import co.com.sofka.domain.round.values.Face;

public class Dice extends Entity<DiceId> {
    private Face face;

    public Dice(DiceId entityId) {
        super(entityId);
    }

    public void throwDice(){
        this.face = new Face((int)(Math.random()*(6-1)+1));
    }

    public Face face(){
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }
}
