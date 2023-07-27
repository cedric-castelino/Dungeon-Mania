package dungeonmania.entities.buildables;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;

public class Sceptre extends Buildable {
        private int duration;

        public Sceptre(int duration) {
                super(null);
                this.duration = duration;
        }

        @Override
        public BattleStatistics applyBuff(BattleStatistics origin) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'applyBuff'");
        }

        @Override
        public void use(Game game) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'use'");
        }

        @Override
        public int getDurability() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getDurability'");
        }

}
