package dungeonmania.goals.states;

import dungeonmania.Game;

public class EnemiesGoalState implements GoalState {
    private int target;

    public EnemiesGoalState(int target) {
        this.target = target;
    }

    @Override
    public boolean achieved(Game game) {
        return game.getEnemiesDestroyed() >= target;
    }

    @Override
    public String toString(Game game) {
        return ":enemies";
    }
}
