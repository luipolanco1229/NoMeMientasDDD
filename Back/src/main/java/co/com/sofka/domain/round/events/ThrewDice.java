package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.Dice;
import co.com.sofka.domain.round.values.DiceId;
import co.com.sofka.domain.round.values.Face;
import co.com.sofka.domain.round.values.RoundId;

import java.util.Map;

public class ThrewDice extends DomainEvent {
    private final RoundId roundId;
    private final Map<DiceId, Face> facesOfDices;


    public ThrewDice(RoundId roundId, Map<DiceId, Face> facesOfDices) {
        super("nomemientas.round.threwdice");
        this.roundId = roundId;
        this.facesOfDices = facesOfDices;
    }

    public RoundId roundId(){
        return roundId;
    }

    public Map<DiceId, Face> facesOfDices(){
        return facesOfDices;
    }

}
