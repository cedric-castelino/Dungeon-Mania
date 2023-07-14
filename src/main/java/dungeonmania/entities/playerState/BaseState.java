package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public class BaseState extends PlayerState {
    public BaseState(Player player) {
        super(player, false, false);
    }

    Player player = getPlayer();

    @Override
    public void transitionBase() {
        // Do nothing
    }

    @Override
    public void transitionInvincible() {
        player.changeState(new InvincibleState(player));
    }

    @Override
    public void transitionInvisible() {
        player.changeState(new InvisibleState(player));
    }
}
