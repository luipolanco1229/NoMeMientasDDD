package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;



public class GameCreated extends DomainEvent {
    private final GameId gameId;

    public GameCreated(GameId gameId){
        super("nomemientas.game.created");
        this.gameId = gameId;
    }

    public GameId getGameId(){
        return gameId;
    }
}
