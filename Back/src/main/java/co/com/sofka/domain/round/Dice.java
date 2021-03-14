package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.round.values.DiceId;

public class Dice extends Entity<DiceId> {
    public Dice(DiceId entityId) {
        super(entityId);
    }
}
