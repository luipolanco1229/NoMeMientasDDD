package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class GameCreated extends DomainEvent {
    private final Map<PlayerId, Player> players;

    public GameCreated(Map <PlayerId, Player> players){
        super("nomemientas.game.created");
        this.players = players;
    }

    public Map<PlayerId, Player> getPlayers(){
        return players;
    }
}
