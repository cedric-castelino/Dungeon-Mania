package dungeonmania.entities.buildables;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;

public class MidnightArmour extends Buildable {
        private int midnightArmourAttack;
        private int midnightArmourDefense;

        public MidnightArmour(int midnightArmourAttack, int midnightArmourDefense) {
                super(null);
                this.midnightArmourAttack = midnightArmourAttack;
                this.midnightArmourDefense = midnightArmourDefense;
        }

        @Override
        public BattleStatistics applyBuff(BattleStatistics origin) {
                return BattleStatistics.applyBuff(origin, createNewBattleStatistics());
        }

        private BattleStatistics createNewBattleStatistics() {
                return new BattleStatistics(0, 0, midnightArmourDefense, midnightArmourAttack, 0);
        }

        @Override
        public void use(Game game) {
                // do nothing
        }

        @Override
        public int getDurability() {
                return 0;
        }
}
