package co.com.sofka.nomemientas.usecase.round;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.round.events.RoundCreated;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;


class CreateRoundUseCaseTest {
    @Test
    void createRound() {
        var event = new GameStarted(Set.of(PlayerId.of("xxx"), PlayerId.of("fff")));
        event.setAggregateRootId("hhhhhh");
        var useCase = new CreateRoundUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var roundCreated = (RoundCreated) events.get(0);
        Assertions.assertEquals("hhhhhh", roundCreated.getGameId().value());
        Assertions.assertEquals(2, roundCreated.getPlayerIds().size());
    }

    @Test
    void ErrorRound() {
        var event = new GameStarted(Set.of(PlayerId.of("xxx")));
        event.setAggregateRootId("hhhhhh");
        var useCase = new CreateRoundUseCase();

        Assertions.assertThrows(BusinessException.class, () -> UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(), "Falta de jugadores");

    }

}

