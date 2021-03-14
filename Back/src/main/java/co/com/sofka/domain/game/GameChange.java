package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.AddedPlayer;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class GameChange extends EventChange {
    public GameChange(Game game) {

        apply((GameCreated event) -> {
            game.gameStarted = Boolean.FALSE;
            game.players = new HashMap<>();
        });

        apply((GameCreated event) -> {
            game.gameStarted = Boolean.TRUE;
        });

        apply((AddedPlayer event) -> {
            if (game.gameStarted.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("No puedes crear un nuevo juego si ya se está realizando otro ");
            }
            game.players.put(event.getPlayerId(),
                    new Player(
                            event.getPlayerId(),
                            event.getPlayerNickname(),
                            event.getMoney()
                    )
            );
        });
    }
}