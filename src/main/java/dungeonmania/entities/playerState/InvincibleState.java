package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public class InvincibleState implements State {
    private PlayerState playerState;

    public InvincibleState(PlayerState state) {
        this.playerState = state;
    }

    @Override
    public void transitionBase() {
        playerState.changeState(playerState.getBaseState());
    }

    @Override
    public void transitionInvincible() {
        playerState.changeState(playerState.getInvincibleState());
    }

    @Override
    public void transitionInvisible() {
        playerState.changeState(playerState.getInvisibleState());
    }
}
