package dungeonmania.entities.collectables;

import dungeonmania.entities.Entity;
import dungeonmania.entities.Player;
import dungeonmania.map.GameMap;

public class OverlapMethod {
        public static void overLapMethod(GameMap map, Entity entity, Entity item) {
                if (entity instanceof Player) {
                        if (!((Player) entity).pickUp(item))
                                return;
                        map.destroyEntity(item);
                }
        }
}
