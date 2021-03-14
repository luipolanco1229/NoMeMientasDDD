package co.com.sofka.domain.game.factory;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.game.values.PlayerNickname;

import java.util.HashSet;
import java.util.Set;

public class PlayerFactory {
    private final Set<Player> players;

    private PlayerFactory(){
        players = new HashSet<>();

    }

    public static PlayerFactory builder(){
        return new PlayerFactory();
    }

    public PlayerFactory newPlayer (PlayerId playerId, PlayerNickname playerNickname, Money money){
        players.add(new Player(playerId, playerNickname, money));
        return this;
    }

    public Set<Player> players(){
        return players;
    }


}
