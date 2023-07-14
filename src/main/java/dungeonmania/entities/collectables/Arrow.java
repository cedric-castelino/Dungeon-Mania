package dungeonmania.entities.collectables;

import dungeonmania.entities.Entity;
import dungeonmania.entities.OverlapMethod;
import dungeonmania.entities.Player;
import dungeonmania.entities.inventory.InventoryItem;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public class Arrow extends Entity implements InventoryItem {
    public Arrow(Position position) {
        super(position);
    }

    @Override
    public boolean canMoveOnto(GameMap map, Entity entity) {
        return true;
    }

    @Override
    public void onOverlap(GameMap map, Entity entity) {
        OverlapMethod.overLapMethod(map, entity, this);
    }

}
