package co.com.sofka.nomemientas.usecase.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.round.Round;
import co.com.sofka.domain.round.command.CreateRound;

public class CreateRoundUseCase extends UseCase<RequestCommand<CreateRound>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateRound> createRoundRequestCommand) {
        var command = input.getCommand();

        var round = Round.from(command.getRoundId(), retrieveEvents());

        round.createRound();

        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
    }
}
