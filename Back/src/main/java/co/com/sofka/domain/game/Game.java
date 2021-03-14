package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.AddedPlayer;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.factory.PlayerFactory;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game extends AggregateEvent <GameId> {

    protected Boolean gameStarted;
    protected Map<PlayerId, Player> players;


    public Game(GameId entityId, PlayerFactory playerFactory){
        super(entityId);
        appendChange(new GameCreated(entityId)).apply();
        playerFactory.players()
                .forEach(player -> addPlayer(player.identity(), player.playerNickname(), player.money()));
    }

    private Game(GameId entityId) {
        super(entityId);
        subscribe(new GameChange(this));
    }

    public static Game from (GameId entityId, List<DomainEvent> events){
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }


    public void startGame() {
        var playersIds = players.keySet();
        appendChange(new GameStarted(playersIds)).apply();
    }
    public void addPlayer(PlayerId playerId, PlayerNickname playerNickname, Money money) {
        appendChange(new AddedPlayer(playerId, playerNickname, money)).apply();
    }
}
