package co.com.sofka.nomemientas.usecase.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.events.ThrewDice;
import co.com.sofka.domain.round.values.Face;
import co.com.sofka.domain.round.values.RoundId;

import java.util.Map;

public class ThrowDiceUseCase extends UseCase<TriggeredEvent<RoundCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RoundCreated> input){
        var event = input.getDomainEvent();
        var roundId = RoundId.of(event.aggregateRootId());
        var faces = new Face(event.)


    }
}
