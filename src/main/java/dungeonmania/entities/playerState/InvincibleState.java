package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public class InvincibleState extends PlayerState {
    public InvincibleState(Player player) {
        super(player, true, false);
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
