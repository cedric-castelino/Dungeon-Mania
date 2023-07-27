package dungeonmania.entities.buildables;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;
// import dungeonmania.entities.enemies.Mercenary;

public class Sceptre extends Buildable {
        private int duration;

        public Sceptre(int duration) {
                super(null);
                this.duration = duration;
        }

        // public void interact(Game game, Mercenary enemy) {
        //         int tickCount = game.getTick();
        //         enemy.setIsAllied(true);
        //         enemy.setStopMindControlTick(tickCount + mindControlDuration);
        // }

        @Override
        public BattleStatistics applyBuff(BattleStatistics origin) {
                return null;
        }

        @Override
        public void use(Game game) {
        }

        @Override
        public int getDurability() {
                return 0;
        }

}
