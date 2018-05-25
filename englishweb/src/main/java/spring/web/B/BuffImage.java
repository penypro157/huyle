package spring.web.B;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BuffImage {
    public static void main(String[] args) {
        File file= new File("1686742-tumblr_l6pwth0gox1qcp8iro1_400.png");
        BufferedImage bufferedImage=null;
        try {
//            Thread thread= new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int i=0;
//                    while (true){
//
//                        System.out.println(i); i++;
//                    }
//                }
            bufferedImage=ImageIO.read(file);

            ImageIO.write(bufferedImage,"png",new File("image1.png"));
            System.out.println("complete;");
            }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
