package dungeonmania.entities.buildables;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;

public class Bow extends Buildable {
    private int durability;

    public Bow(int durability) {
        super(null);
        this.durability = durability;
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
        return new BattleStatistics(0, 0, 0, 2, 1);
    }

    private void destroyItem(Game game) {
        game.getPlayer().remove(this);
    }

    @Override
    public int getDurability() {
        return durability;
    }
}
