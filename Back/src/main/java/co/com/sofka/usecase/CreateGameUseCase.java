package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.command.CreateGame;
import co.com.sofka.domain.game.values.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateGame> input) {
        var command = input.getCommand();
        var gameId = new GameId();

        if(command.getPlayers().size() < 3 ){
            throw new BusinessException(gameId.value(), "Debes ingresar por lo menos 3 jugadores");
        }
        var game = new Game(new GameId(), command.getPlayers());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}
