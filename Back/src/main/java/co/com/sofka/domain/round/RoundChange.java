package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.events.ThrewDice;
import co.com.sofka.domain.round.values.DiceId;

import java.util.HashMap;

public class RoundChange extends EventChange {
    public RoundChange(Round round){
        apply((RoundCreated event)-> {
            round.gameId = event.getGameId();
            round.dices = new HashMap<>();
            round.stages = new HashMap<>();
            round.playerIds = event.getPlayerIds();
        }
        );
        apply((ThrewDice event)-> {
            for (var i = 1; i <= 6; i++) {
                round.dices.put(DiceId.of(i), new Dice(DiceId.of(i)));
                round.dices.get(i).setFace(event.facesOfDices().get(i));
            }
        }

                );
    }
}
