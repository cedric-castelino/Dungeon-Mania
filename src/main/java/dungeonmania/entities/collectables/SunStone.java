package dungeonmania.entities.collectables;

import dungeonmania.entities.Entity;
import dungeonmania.entities.OverlapMethod;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public class SunStone extends Treasure {
        public SunStone(Position position) {
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
