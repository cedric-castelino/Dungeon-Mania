package dungeonmania.goals;

import org.json.JSONArray;
import org.json.JSONObject;
import dungeonmania.goals.states.*;

public class GoalFactory {
    public static Goal createGoal(JSONObject jsonGoal, JSONObject config) {
        JSONArray subgoals;
        switch (jsonGoal.getString("goal")) {
        case "AND":
            subgoals = jsonGoal.getJSONArray("subgoals");
            return new Goal(new AndGoalState(createGoal(subgoals.getJSONObject(0), config),
                    createGoal(subgoals.getJSONObject(1), config)));
        case "OR":
            subgoals = jsonGoal.getJSONArray("subgoals");
            return new Goal(new OrGoalState(createGoal(subgoals.getJSONObject(0), config),
                    createGoal(subgoals.getJSONObject(1), config)));
        case "exit":
            return new Goal(new ExitGoalState());
        case "boulders":
            return new Goal(new BouldersGoalState());
        case "treasure":
            int treasureGoal = config.optInt("treasure_goal", 1);
            return new Goal(new TreasureGoalState(treasureGoal));
<<<<<<< HEAD
        case "enemies":
            int enemyGoal = config.optInt("enemy_goal", 1);
            return new Goal(new EnemiesGoalState(enemyGoal));
        case "spawner":
            return new Goal(new SpawnerGoalState());
=======
>>>>>>> f1e7580aed37822d9fc185c37280dcbaa41ef9f3
        default:
            return null;
        }
    }
}
