package dungeonmania.entities.playerState;

import dungeonmania.entities.Player;

public abstract class PlayerState {
    private Player player;
    private boolean isInvincible = false;
    private boolean isInvisible = false;
    private State invincibleState;
    private State baseState;
    private State invisibleState;
    private State state;

    public PlayerState(Player player, boolean isInvincible, boolean isInvisible) {
        this.player = player;
        this.isInvincible = isInvincible;
        this.isInvisible = isInvisible;

        invincibleState = new InvincibleState(this);
        invisibleState = new InvisibleState(this);
        baseState = new BaseState(this);

        if (isInvincible) {
            this.state = invincibleState;
        } else if (isInvisible) {
            this.state = invisibleState;
        } else {
            this.state = baseState;
        }

    }

    public void changeState(State state) {
        this.state = state;

    }

    public boolean isInvincible() {
        return isInvincible;
    };

    public boolean isInvisible() {
        return isInvisible;
    };

    public Player getPlayer() {
        return player;
    }

    public State getInvincibleState() {
        return invincibleState;
    }

    public State getBaseState() {
        return baseState;
    }

    public State getInvisibleState() {
        return invisibleState;
    }

    public State getState() {
        return state;
    }

    

}
