package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Game extends AggregateEvent <GameId> {

    protected Map<PlayerId, Player> listPlayers;

    public Game(GameId entityId, Set<Player> players){
        super(entityId);
        Map<PlayerId, Player> newPlayers = new HashMap<>();
        players.forEach(player -> newPlayers.put(player.identity(), player));
        appendChange(new GameCreated(newPlayers)).apply();
    }

    private Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }

    public static Game from (GameId entityId, Set<DomainEvent> events){
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }



}
