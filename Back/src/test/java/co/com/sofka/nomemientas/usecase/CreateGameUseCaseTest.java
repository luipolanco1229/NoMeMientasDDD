package co.com.sofka.nomemientas.usecase;



import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

import co.com.sofka.domain.game.command.CreateGame;
import co.com.sofka.domain.game.events.AddedPlayer;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.nomemientas.usecase.game.CreateGameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;


class CreateGameUseCaseTest {

    @Test
    void CreateAGame(){
        var playerNicknames = Map.of(
                PlayerId.of("xxxxx"), new PlayerNickname("Luisa Polanco"),
                PlayerId.of("ffff"), new PlayerNickname("Sebas Davila")
        );
        var playersMoney = Map.of(
                PlayerId.of("xxxxx"), new Money(5000L),
                PlayerId.of("ffff"), new Money(6000L)
        );
        var command = new CreateGame(playersMoney, playerNicknames);
        var useCase = new CreateGameUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameCreated = (GameCreated)events.get(0);
        var addPlayerForLuisa = (AddedPlayer)events.get(2);
        var addPlayerForSebas = (AddedPlayer)events.get(1);

        Assertions.assertTrue(Objects.nonNull(gameCreated.getGameId().value()));

        Assertions.assertEquals("Luisa Polanco", addPlayerForLuisa.getPlayerNickname().value());
        Assertions.assertEquals(5000L, addPlayerForLuisa.getMoney().value());
        Assertions.assertEquals("xxxxx", addPlayerForLuisa.getPlayerId().value());

        Assertions.assertEquals("Sebas Davila", addPlayerForSebas.getPlayerNickname().value());
        Assertions.assertEquals(6000L, addPlayerForSebas.getMoney().value());
        Assertions.assertEquals("ffff", addPlayerForSebas.getPlayerId().value());

    }


    @Test
    void errorCreateGame(){
        var playersNickname = Map.of(
                PlayerId.of("xxxxx"), new PlayerNickname("Luisa Polanco")
        );
        var playersMoney = Map.of(
                PlayerId.of("xxxxx"), new Money(5000L)
        );
        var command = new CreateGame(playersMoney, playersNickname);
        var useCase = new CreateGameUseCase();


        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        }, "No tiene la cantidad necesaria de jugadores");

    }

}