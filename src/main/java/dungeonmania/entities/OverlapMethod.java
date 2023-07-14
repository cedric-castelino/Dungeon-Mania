package dungeonmania.entities;

import dungeonmania.entities.inventory.InventoryItem;

public class OverlapMethod {
        public boolean overLapMethod(Player player, Entity item) {
                if (item instanceof InventoryItem) {
                        if (!((Player) player).pickUp(item))
                                return false;
                }
                return true;
        }
}
