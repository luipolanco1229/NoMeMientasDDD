package co.com.sofka.domain.round;

import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.GameChange;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.factory.PlayerFactory;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.values.RoundId;

import java.util.List;
import java.util.Set;

public class Round extends AggregateEvent<RoundId> {
    protected GameId gameId;
    protected Set<Stage> stages;
    protected Set<Dice> dices;


    public Round(RoundId entityId, PlayerFactory playerFactory){
        super(entityId);
        appendChange(new RoundCreated(entityId)).apply();

    }

    private Round(RoundId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }

    public static Round from (RoundId entityId, List<DomainEvent> events){
        var round = new Round(entityId);
        events.forEach(round::applyEvent);
        return round;
    }
}
