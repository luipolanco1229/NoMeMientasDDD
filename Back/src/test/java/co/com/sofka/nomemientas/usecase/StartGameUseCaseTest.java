package co.com.sofka.nomemientas.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.game.command.StartGame;
import co.com.sofka.domain.game.events.AddedPlayer;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.domain.generic.DomainEvent;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartGameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void startGame(){
        var id = GameId.of("xxxx");
        var command = new StartGame(id);
        var useCase = new StartGameUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameStarted = (GameStarted)events.get(0);
        Assertions.assertEquals(3, gameStarted.getPlayersIds().size());

    }

    private List<DomainEvent> eventStored(GameId id) {
        return List.of(
                new GameCreated(id),
                new AddedPlayer(PlayerId.of("ffff"), new PlayerNickname("Luisa Polanco"), new Money(5000L)),
                new AddedPlayer(PlayerId.of("gggg"), new PlayerNickname("Luisa Polanco"), new Money(8000L)),
                new AddedPlayer(PlayerId.of("hhhh"), new PlayerNickname("Luisa Polanco"), new Money(9000L))
        );
    }
}