package dungeonmania.entities.playerState;

public class BaseState implements State {
        private PlayerState playerState;

        public BaseState(PlayerState state) {
                this.playerState = state;
        }

        @Override
        public void transitionBase() {
                // Do nothing
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
