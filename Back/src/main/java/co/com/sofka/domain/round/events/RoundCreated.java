package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.values.RoundId;

public class RoundCreated extends DomainEvent {
    private final RoundId roundId;

    public RoundCreated(RoundId roundId){
        super("nomemientas.round.created");
        this.roundId = roundId;
    }

    public RoundId getRoundId(){
        return roundId;
    }
}
