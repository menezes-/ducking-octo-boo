package org.freerealm.executor.command;

import org.freerealm.executor.CommandResult;
import java.util.Iterator;
import java.util.Random;
import org.freerealm.tile.Tile;
import org.freerealm.tile.TileType;
import org.freerealm.Realm;
import org.freerealm.map.Coordinate;
import org.freerealm.map.Map;
import org.freerealm.tile.FreeRealmTile;

/**
 * Command class to resize world map or given realm to new width and height.
 * Resized map will replace current map of the realm and all items (units,
 * cities etc.) will be reset. Map width and height must be defined for
 * resizing, if any of these values are negative command will return an error.
 * <p>
 * In addition to width and height, tile type can be also be specified. In this
 * case all of the new map's tiles have the given type. If tile type is not
 * given probabilities defined in tile type configuration will be used to
 * randomly generate tile types. If tile type is defined but is null a runtime
 * exception will occur.
 *
 * @author Deniz ARIKAN
 */
public class ResizeMapCommand extends AbstractCommand {

    private int width = 0;
    private int height = 0;
    private Random rand = new Random(System.currentTimeMillis());

    /**
     * Constructs a ResizeMapCommand using width, height.
     *
     * @param width Width of resized map
     * @param height Height of resized map
     */
    public ResizeMapCommand(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Executes command to create resize map for realm.
     *
     * @param realm Realm to execute the command
     * @return CommandResult
     */
    public CommandResult execute() {
        Map currentMap = getRealm().getMap();
        int probabilityTotal = 0;
        Iterator<TileType> tileIterator = getRealm().getTileTypeManager().getTileTypesIterator();
        while (tileIterator.hasNext()) {
            TileType tileType = tileIterator.next();
            probabilityTotal = probabilityTotal + tileType.getProbability();
        }
        int newColumnsToAdd = width - currentMap.getWidth();
        int newRowsToAdd = height - currentMap.getHeight();
        int columnSegmentSize = currentMap.getWidth() / newColumnsToAdd;
        int rowSegmentSize = currentMap.getHeight() / newRowsToAdd;
        Tile[][] mapItems = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile newTile;
                if ((i != 0 && i % (columnSegmentSize + 1) == 0) || (j != 0 && j % (rowSegmentSize + 1) == 0)) {
                    newTile = new FreeRealmTile(generateTileType(getRealm(), probabilityTotal));
                } else {
                    int targetX = i - i / columnSegmentSize;
                    int targetY = j - j / rowSegmentSize;
                    Coordinate coordinate = new Coordinate(targetX, targetY);
                    newTile = currentMap.getTile(coordinate);
                }
                mapItems[i][j] = newTile;
            }
        }
        currentMap.setMapItems(mapItems);
        getRealm().setMap(currentMap);
        return new CommandResult(CommandResult.RESULT_OK, "");
    }

    private TileType generateTileType(Realm realm, int probabilityTotal) {
        int randomNumber = rand.nextInt(probabilityTotal);
        Iterator tileIterator = realm.getTileTypeManager().getTileTypesIterator();
        TileType tileType = null;
        while (tileIterator.hasNext()) {
            tileType = (TileType) tileIterator.next();
            randomNumber = randomNumber - tileType.getProbability();
            if (randomNumber < 0) {
                return tileType;
            }
        }
        return tileType;
    }
}
