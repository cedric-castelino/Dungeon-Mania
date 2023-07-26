package dungeonmania.entities.playerState;

import dungeonmania.battles.BattleStatistics;
import dungeonmania.entities.Player;

public class BaseState extends PlayerState {
        public BaseState(Player player) {
                super(player, false, false);
        }

        public BattleStatistics applyBuff(BattleStatistics origin) {
                return BattleStatistics.applyBuff(origin, createNewBaseState());
        }

        public BattleStatistics createNewBaseState() {
                return new BattleStatistics(0, 0, 0, 0, 0, false, false);
        }

}
