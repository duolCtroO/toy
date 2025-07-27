package oort.cloud.document.importer;

import oort.cloud.document.domain.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageImporter implements Importer{
    @Override
    public Document importFile(File file) throws IOException {
        Map<String, String> attributes = new HashMap<>();
        attributes.put(Attributes.PATH.getValue(), file.getPath());

        BufferedImage image = ImageIO.read(file);
        attributes.put(Attributes.WIDTH.getValue(), String.valueOf(image.getWidth()));
        attributes.put(Attributes.HEIGHT.getValue(), String.valueOf(image.getHeight()));
        attributes.put(Attributes.TYPE.getValue(), "IMAGE");

        return new Document(attributes);
    }
}
