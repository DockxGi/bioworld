package view.assets.mappings;

import model.land.tile.Ground;

import java.util.EnumMap;
import java.util.Map;

/**
 * All files about {@link Ground} have the same name (e.g. grass.png, grass.txt).
 * This class is responsible for mapping the {@link Ground} to the name of the file(s).
 */
public class GroundFileNameMapping {
    private static GroundFileNameMapping mapping;
    private static final Map<Ground, String> groundFileNames = new EnumMap<>(Ground.class);

    public static GroundFileNameMapping getInstance(){
        if (mapping == null){
            mapping = new GroundFileNameMapping();
        }
        return mapping;
    }

    private GroundFileNameMapping() {
        groundFileNames.put(Ground.DIRT, "dirt");
        groundFileNames.put(Ground.GRASS, "grass");
        groundFileNames.put(Ground.MOUNTAIN, "mountain");
    }

    public String getFileName(Ground ground){
        return groundFileNames.get(ground);
    }
}
