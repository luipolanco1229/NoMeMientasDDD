package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

public class PlayerNickname implements ValueObject<String> {
    private String value;

    public PlayerNickname(String nickname) {
        this.value = nickname;
        if (nickname.isEmpty()){
            throw new IllegalArgumentException("Ingrese un nombre");
        }
    }

    public String value(){
        return value;
    }
}
