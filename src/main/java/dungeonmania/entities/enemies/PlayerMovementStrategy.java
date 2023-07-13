package dungeonmania.entities.enemies;

import dungeonmania.Game;
import dungeonmania.entities.Player;
import dungeonmania.map.GameMap;
import dungeonmania.util.Direction;
import dungeonmania.util.Position;

public class PlayerMovementStrategy implements MovementStrategy {

        @Override
        public Position move(Enemy enemy, Game game) {

                GameMap map = game.getMap();
                Player player = game.getPlayer();
                Position plrDiff = Position.calculatePositionBetween(player.getPosition(), enemy.getPosition());
        
                Position moveX = (plrDiff.getX() >= 0) ? Position.translateBy(enemy.getPosition(), Direction.RIGHT)
                        : Position.translateBy(enemy.getPosition(), Direction.LEFT);
                Position moveY = (plrDiff.getY() >= 0) ? Position.translateBy(enemy.getPosition(), Direction.UP)
                        : Position.translateBy(enemy.getPosition(), Direction.DOWN);
                Position offset = enemy.getPosition();
                if (plrDiff.getY() == 0 && map.canMoveTo(enemy, moveX))
                    offset = moveX;
                else if (plrDiff.getX() == 0 && map.canMoveTo(enemy, moveY))
                    offset = moveY;
                else if (Math.abs(plrDiff.getX()) >= Math.abs(plrDiff.getY())) {
                    if (map.canMoveTo(enemy, moveX))
                        offset = moveX;
                    else if (map.canMoveTo(enemy, moveY))
                        offset = moveY;
                    else
                        offset = enemy.getPosition();
                } else {
                    if (map.canMoveTo(enemy, moveY))
                        offset = moveY;
                    else if (map.canMoveTo(enemy, moveX))
                        offset = moveX;
                    else
                        offset = enemy.getPosition();
                }
                return offset;


        }

}
