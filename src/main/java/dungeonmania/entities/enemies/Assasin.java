package dungeonmania.entities.enemies;

import dungeonmania.entities.Player;
import dungeonmania.entities.collectables.Treasure;
import dungeonmania.util.Position;

public class Assasin extends Mercenary {
        public static final double DEFAULT_ATTACK = 10.0; // double the mercenarys damage
        public static final double DEFAULT_HEALTH = 10.0;

        private int bribeAmount = Mercenary.DEFAULT_BRIBE_AMOUNT;
        private int bribeRadius = Mercenary.DEFAULT_BRIBE_RADIUS;

        private boolean allied = false;

        public Assasin(Position position, double health, double attack, int bribeAmount, int bribeRadius,
                        double allyAttack, double allyDefence) {
                super(position, health, attack, bribeAmount, bribeRadius, allyAttack, allyDefence);
        }

        public boolean isAllied() {
                return allied;
        }

        

}

