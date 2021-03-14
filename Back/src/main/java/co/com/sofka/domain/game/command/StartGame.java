package co.com.sofka.domain.game.command;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.Command;

public class StartGame implements Command {

    private final GameId gameId;

    public StartGame(GameId gameId){
        this.gameId = gameId;
    }

    public GameId getGameId(){
        return gameId;
    }

}
