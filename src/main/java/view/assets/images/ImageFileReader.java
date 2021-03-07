package view.assets.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageFileReader {
    private static ImageFileReader imageReader;

    private Map<String, BufferedImage> loadedImages;

    private ImageFileReader() {
        loadedImages = new HashMap<>();
    }

    public static ImageFileReader getInstance() {
        if (imageReader == null){
            imageReader = new ImageFileReader();
        }
        return imageReader;
    }

    public BufferedImage readImage(String path){
        try {
            if (loadedImages.get(path) == null){
                BufferedImage image = ImageIO.read(ImageFileReader.class.getResource(path));
                this.loadedImages.put(path, image);
                return image;
            } else {
                return loadedImages.get(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
