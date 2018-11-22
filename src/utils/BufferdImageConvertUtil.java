package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferdImageConvertUtil {
	
    public static byte[] getImageBytes(BufferedImage image,
            String imageFormat) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BufferedOutputStream os = new BufferedOutputStream(bos);
        image.flush();
        ImageIO.write(image, imageFormat, os);
        os.flush();
        os.close();
        return bos.toByteArray();
    }

}
