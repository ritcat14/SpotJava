package SpotJava.game.maps;

import java.util.List;
import java.util.ArrayList;

import SpotJava.core.maps.Map;
import SpotJava.core.maps.Tile;
import SpotJava.core.util.Images;
import SpotJava.game.entities.Player;

public class StartMap extends Map {

    public StartMap(Player player) {
        super(player);
        List<Tile> availableTiles = new ArrayList<Tile>();
        availableTiles.add(new Tile(Images.getImage("images/tiles/grass.png")));
        loadMap("maps/map1.txt", availableTiles);
    }
    
}