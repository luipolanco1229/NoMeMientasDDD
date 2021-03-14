package co.com.sofka.domain.game.command;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.generic.Command;

import java.util.Map;
import java.util.Set;

public class CreateGame implements Command {
    private final Set<Player>  players;

    public CreateGame(Set <Player> players){
        this.players = players;
    }

    public Set<Player> getPlayers(){
        return players;
    }
}
