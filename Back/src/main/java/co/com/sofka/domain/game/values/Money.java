package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

public class Money implements ValueObject<Long> {
        private final Long money;


    public Money(Long money) {
        this.money = money;
        if (money<0){
            throw new IllegalArgumentException("Tienes que tener dinero para participar en el juego");
        }
    }

    public Money increase (Long winMoney){
        return new Money(this.money + winMoney);
    }

    public Long value(){
        return money;
    }
}
