package co.com.sofka.domain.round;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.events.ThrewDice;
import co.com.sofka.domain.round.values.DiceId;
import co.com.sofka.domain.round.values.Face;
import co.com.sofka.domain.round.values.RoundId;
import co.com.sofka.domain.round.values.StageId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Round extends AggregateEvent<RoundId> {

    protected GameId gameId;
    protected Map<DiceId, Dice> dices;
    protected Map <StageId, Stage> stages;
    protected Set<PlayerId> playerIds;


    public Round(RoundId entityId, GameId gameId, Set<PlayerId> playerIds){
        super(entityId);
        appendChange(new RoundCreated(playerIds, gameId)).apply();

    }

    private Round(RoundId entityId) {
        super(entityId);
        subscribe(new RoundChange(this));
    }

    public static Round from (RoundId entityId, List<DomainEvent> events){
        var round = new Round(entityId);
        events.forEach(round::applyEvent);
        return round;
    }

    public void throwDices() {

        var dices =
                Map.of(DiceId.of(1), new Dice(DiceId.of(1)),
                DiceId.of(2), new Dice(DiceId.of(2)),
                DiceId.of(3), new Dice(DiceId.of(3)),
                DiceId.of(4), new Dice(DiceId.of(4)),
                DiceId.of(5), new Dice(DiceId.of(5)),
                DiceId.of(6), new Dice(DiceId.of(6))
                );

            dices.forEach(((diceId, dice) -> dice.throwDice()));

            var faces = new HashMap<DiceId, Face>();
            dices.forEach(((diceId, dice) -> faces.put(diceId, dice.face())));
            appendChange(new ThrewDice(entityId, faces)).apply();
    }
}
