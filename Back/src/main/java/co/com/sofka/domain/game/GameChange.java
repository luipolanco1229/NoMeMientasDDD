package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.generic.EventChange;

public class GameChange extends EventChange {
    public GameChange (Game game){
        apply((GameCreated event) -> {
            game.listPlayers = event.getPlayers();

        });
    }
}
