package view.assets.images;

import model.land.tile.Ground;
import view.assets.mappings.GroundFileNameMapping;

import java.awt.image.BufferedImage;

/**
 * Responsible for retrieving Ground Images
 */
public class GroundImages {
    public static final String GROUND_IMAGES_PATH = "/images/ground/";
    public static final String GROUND_IMAGES_EXTENSION = ".png";

    private static String getImagePath(Ground ground){
        return GROUND_IMAGES_PATH + GroundFileNameMapping.getInstance().getFileName(ground) + GROUND_IMAGES_EXTENSION;
    }

    public static BufferedImage imageOf(Ground ground){
        String imagePath = getImagePath(ground);
        return ImageFileReader.getInstance().readImage(imagePath);
    }
}
