package dungeonmania.entities.playerState;

public interface State {
        public abstract void transitionInvisible();

        public abstract void transitionInvincible();

        public abstract void transitionBase();

}
