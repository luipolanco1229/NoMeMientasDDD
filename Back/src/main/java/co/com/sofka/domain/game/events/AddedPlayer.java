package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedPlayer extends DomainEvent {
    private final PlayerId playerId;
    private final PlayerNickname playerNickname;
    private final Money money;

    public AddedPlayer(PlayerId playerId, PlayerNickname playerNickname, Money money){
        super("nomemientas.game.addedplayer");
        this.playerId = playerId;
        this.playerNickname = playerNickname;
        this.money = money;
    }

    public PlayerId getPlayerId(){
        return playerId;
    }

    public Money getMoney(){
        return money;
    }
    public PlayerNickname getPlayerNickname(){
        return playerNickname;
    }
}
