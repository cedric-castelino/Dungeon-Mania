package dungeonmania.entities.collectables;

import dungeonmania.entities.Entity;
import dungeonmania.entities.OverlapMethod;
import dungeonmania.entities.Player;
import dungeonmania.entities.inventory.InventoryItem;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public class Key extends Entity implements InventoryItem {
    private int number;

    public Key(Position position, int number) {
        super(position);
        this.number = number;
    }

    @Override
    public boolean canMoveOnto(GameMap map, Entity entity) {
        return true;
    }

    @Override
    public void onOverlap(GameMap map, Entity entity) {
        OverlapMethod.overLapMethod(map, entity, this);
    }

    public int getnumber() {
        return number;
    }

}
