package spring.web.beans;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageHandler {
    public static String getFormatName(File file) {
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
            while (imageReaders.hasNext()) {
                ImageReader reader = (ImageReader) imageReaders.next();
                return reader.getFormatName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    public static boolean deleteImage(String rootPath,String folder, String name) {

        File file = new File(rootPath+folder + name);
        try {
            System.out.println(rootPath+folder + name);
            if(file.delete())
            return true;

        } catch (Exception e) {


        }
        return false;

    }
}
