package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public class InvisibleState implements State {
    private PlayerState playerState;

    public InvisibleState(PlayerState state) {
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
