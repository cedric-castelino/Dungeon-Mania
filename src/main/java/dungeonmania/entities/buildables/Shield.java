package dungeonmania.entities.buildables;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;

public class Shield extends Buildable {
        private int durability;
        private double defence;

        public Shield(int durability, double defence) {
                super(null);
                this.durability = durability;
                this.defence = defence;
        }

        @Override
        public void use(Game game) {
                durability--;
                if (durability <= 0) {
                        destroyItem(game);
                }
        }

        @Override
        public BattleStatistics applyBuff(BattleStatistics origin) {
                return BattleStatistics.applyBuff(origin, createNewBattleStatistics());
        }

        private BattleStatistics createNewBattleStatistics() {
                return new BattleStatistics(0, 0, defence, 1, 1);
        }

        private void destroyItem(Game game) {
                game.getPlayer().remove(this);
        }

        @Override
        public int getDurability() {
                return durability;
        }

}
