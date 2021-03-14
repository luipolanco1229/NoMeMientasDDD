package co.com.sofka.nomemientas.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.command.CreateGame;
import co.com.sofka.domain.game.factory.PlayerFactory;
import co.com.sofka.domain.game.values.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateGame> input) {
        var command = input.getCommand();
        var gameId = new GameId();

        var factory = PlayerFactory.builder();
        command.getPlayersNickname().forEach(((playerId, playerNickname) ->
                factory.newPlayer(playerId, playerNickname, command.getPlayersMoney().get(playerId))));

        if (factory.players().size() < 2) {
            throw new BusinessException(gameId.value(), "Ingrese una cantidad válida de jugadores");
        }

        var game = new Game(gameId, factory);

        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}