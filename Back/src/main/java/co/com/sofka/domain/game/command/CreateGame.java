package co.com.sofka.domain.game.command;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.domain.generic.Command;

import java.util.Map;
import java.util.Set;

public class CreateGame implements Command {
    private final Map<PlayerId, Money> playersMoney;
    private final Map<PlayerId, PlayerNickname> playersNickname;

    public CreateGame(Map<PlayerId, Money> playersMoney, Map<PlayerId, PlayerNickname> playersNickname) {
        this.playersMoney = playersMoney;
        this.playersNickname = playersNickname;
    }

    public Map<PlayerId, Money> getPlayersMoney() {
        return playersMoney;
    }

    public Map<PlayerId, PlayerNickname> getPlayersNickname() {
        return playersNickname;
    }
}
