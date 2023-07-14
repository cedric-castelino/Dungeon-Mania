package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public class InvisibleState extends PlayerState {
    public InvisibleState(Player player) {
        super(player, false, true);
    }

    Player player = getPlayer();

    @Override
    public void transitionBase() {
        player.changeState(new BaseState(player));
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
