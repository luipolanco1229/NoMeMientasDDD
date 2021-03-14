package co.com.sofka.domain.game;

import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;
import co.com.sofka.domain.generic.AggregateEvent;

public class Player extends AggregateEvent <PlayerId> {

    private PlayerNickname playerNickname;
    private Money money;

    public Player(PlayerId entityId, PlayerNickname playerNickname, Money money) {
        super(entityId);
        this.playerNickname = playerNickname;
        this.money = money;
    }

    public void increaseMoney(Long winMoney){
        this.money = this.money.increase(winMoney);

    }

    public Money money(){
        return money;
    }

    public PlayerNickname playerNickname(){
        return playerNickname;
    }

}
