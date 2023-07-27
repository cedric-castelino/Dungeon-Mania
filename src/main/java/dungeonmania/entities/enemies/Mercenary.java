package dungeonmania.entities.enemies;

import dungeonmania.Game;
import dungeonmania.battles.BattleStatistics;
import dungeonmania.entities.Entity;
import dungeonmania.entities.Interactable;
import dungeonmania.entities.Player;
import dungeonmania.entities.buildables.Sceptre;
import dungeonmania.entities.collectables.Treasure;
import dungeonmania.entities.collectables.potions.InvincibilityPotion;
import dungeonmania.entities.collectables.potions.InvisibilityPotion;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public class Mercenary extends Enemy implements Interactable {
        public static final int DEFAULT_BRIBE_AMOUNT = 1;
        public static final int DEFAULT_BRIBE_RADIUS = 1;
        public static final double DEFAULT_ATTACK = 5.0;
        public static final double DEFAULT_HEALTH = 10.0;

        private int bribeAmount = Mercenary.DEFAULT_BRIBE_AMOUNT;
        private int bribeRadius = Mercenary.DEFAULT_BRIBE_RADIUS;

        private double allyAttack;
        private double allyDefence;
        private boolean allied = false;
        private boolean isAdjacentToPlayer = false;

        private int stopMindControlTick = 0;

        public Mercenary(Position position, double health, double attack, int bribeAmount, int bribeRadius,
                        double allyAttack, double allyDefence) {
                super(position, health, attack);
                this.bribeAmount = bribeAmount;
                this.bribeRadius = bribeRadius;
                this.allyAttack = allyAttack;
                this.allyDefence = allyDefence;
        }

        public boolean isAllied() {
                return allied;
        }

        public void setAllied(boolean allied) {
                this.allied = allied;
        }

        public void setStopMindControlTick(int stopMindControlTick) {
                this.stopMindControlTick = stopMindControlTick;
        }

        public void trackMindControl(Game game) {
                if (game.getTick() == stopMindControlTick) {
                        setAllied(false);
                }
        }

        public int getStopMindControlTick() {
                return stopMindControlTick;
        }

        @Override
        public void onOverlap(GameMap map, Entity entity) {
                if (allied)
                        return;
                super.onOverlap(map, entity);
        }

        /**
         * check whether the current merc can be bribed
         * @param player
         * @return
         */
        private boolean canBeBribed(Player player) {
                return bribeRadius >= 0 && player.countEntityOfType(Treasure.class) >= bribeAmount;
        }

        /**
         * bribe the merc
         */
        private void bribe(Player player) {
                for (int i = 0; i < bribeAmount; i++) {
                        player.use(Treasure.class);
                }

        }

        @Override
        public void interact(Player player, Game game) {

                if (player.hasItem(Sceptre.class)) {
                        Sceptre sceptre = player.getItem(Sceptre.class);
                        setAllied(true);
                        sceptre.interact(game, this);
                } else {
                        setAllied(true);
                        bribe(player);
                        if (!isAdjacentToPlayer && Position.isAdjacent(player.getPosition(), getPosition()))
                                isAdjacentToPlayer = true;
                }
        }

        private MovementStrategy movementStrategy;

        public void setMovementStrategy(MovementStrategy movementStrategy) {
                this.movementStrategy = movementStrategy;
        }

        @Override
        public void move(Game game) {
                Position nextPos;
                GameMap map = game.getMap();
                Player player = game.getPlayer();
                if (allied) {
                        trackMindControl(game);
                        nextPos = isAdjacentToPlayer ? player.getPreviousDistinctPosition()
                                        : map.dijkstraPathFind(getPosition(), player.getPosition(), this);
                        if (!isAdjacentToPlayer && Position.isAdjacent(player.getPosition(), nextPos))
                                isAdjacentToPlayer = true;
                } else if (player.getEffectivePotion() instanceof InvisibilityPotion) {
                        // Move random
                        this.movementStrategy = new RandomMovement();
                        nextPos = movementStrategy.move(this, game);
                        map.moveTo(this, nextPos);

                } else if (player.getEffectivePotion() instanceof InvincibilityPotion) {
                        this.movementStrategy = new PlayerMovementStrategy();
                        nextPos = movementStrategy.move(this, game);
                } else {
                        // Follow hostile
                        nextPos = map.dijkstraPathFind(getPosition(), player.getPosition(), this);
                }
                map.moveTo(this, nextPos);
        }

        @Override
        public boolean isInteractable(Player player) {
                if (checkSceptre(player)) {
                        return !allied;
                } else {
                        return !allied && canBeBribed(player);
                }
        }

        public boolean checkSceptre(Player player) {
                return player.hasItem(Sceptre.class);
        }

        @Override
        public BattleStatistics getBattleStatistics() {
                if (!allied)
                        return super.getBattleStatistics();
                return new BattleStatistics(0, allyAttack, allyDefence, 1, 1);
        }
}
