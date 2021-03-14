package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class GameStarted extends DomainEvent {
    private final Set<PlayerId> playersIds;

    public GameStarted(Set<PlayerId> playersIds){
        super("nomemientas.game.gamestarted");
        this.playersIds = playersIds;
    }

    public Set<PlayerId> getPlayersIds(){
        return playersIds;
    }

}
