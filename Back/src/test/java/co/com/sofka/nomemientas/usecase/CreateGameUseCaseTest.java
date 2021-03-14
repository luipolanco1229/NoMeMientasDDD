package co.com.sofka.nomemientas.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.command.CreateGame;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.usecase.CreateGameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

class CreateGameUseCaseTest {

    @Test
    void createGame(){
        var command = new CreateGame(Set.of(
                new Player(PlayerId.of("xxxx"), new PlayerNickname("Raul Alzate"), new Money(5000L)),
                new Player(PlayerId.of("ffff"), new PlayerNickname("Andres"), new Money(7000L)),
                new Player(PlayerId.of("tttt"), new PlayerNickname("Camilo"), new Money(6000L))
        ));
        var createGameUseCase = new CreateGameUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(createGameUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameCreated = (GameCreated)events.get(0);

        Assertions.assertEquals(3, gameCreated.getPlayers().size());
        Assertions.assertEquals("Raul Alzate", gameCreated.getPlayers().get(PlayerId.of("xxxx")).playerNickname().value());
        Assertions.assertEquals("Andres", gameCreated.getPlayers().get(PlayerId.of("ffff")).playerNickname().value());
        Assertions.assertEquals("Camilo", gameCreated.getPlayers().get(PlayerId.of("tttt")).playerNickname().value());
        gameCreated.getPlayers().forEach((playerId, player)  -> System.out.println(player.playerNickname().value()));
    }

}

