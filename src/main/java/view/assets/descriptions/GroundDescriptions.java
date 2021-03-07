package view.assets.descriptions;

import model.land.tile.Ground;
import view.assets.mappings.GroundFileNameMapping;

/**
 * Responsible of retrieving descriptions of {@link model.land.tile.Ground}
 */
public class GroundDescriptions {

    public static final String GROUND_DESCRIPTIONS_PATH = "/descriptions/ground/";
    public static final String GROUND_DESCRIPTIONS_EXTENSION = ".txt";

    private static String getDescriptionPath(Ground ground){
        return GROUND_DESCRIPTIONS_PATH + GroundFileNameMapping.getInstance().getFileName(ground) + GROUND_DESCRIPTIONS_EXTENSION;
    }

    public static String getDescriptionOf(Ground ground){
        String descriptionFilePath = getDescriptionPath(ground);
        return TextFileReader.getInstance().readText(descriptionFilePath);
    }
}
