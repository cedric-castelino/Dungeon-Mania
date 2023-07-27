package dungeonmania.goals.states;

import dungeonmania.Game;
import dungeonmania.entities.enemies.Spawner;

public class SpawnerGoalState implements GoalState {
    @Override
    public boolean achieved(Game game) {
        return game.getMap().getEntities(Spawner.class).size() <= 0;
    }

    @Override
    public String toString(Game game) {
        return ":spawner";
    }
}
