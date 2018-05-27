package spring.web.B;

import org.apache.commons.codec.digest.DigestUtils;
import spring.web.beans.ImageHandler;
import spring.web.beans.Mail;
import spring.web.beans.SendMail;
import spring.web.beans.VerifyMail;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class classC {
    private int a;
    private int b;

    public classC(int b) {
        this.b = b;
    }

    public classC() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
//        File file= new File("F:\\Photos\\17545128_1944547472439894_7650828996855835218_o.jpg");
//        BufferedImage image=null;
//        try {
//
//             image = ImageIO.read(file);
//            System.out.println(image.getHeight());
//            System.out.println(image.getWidth());
//             ImageIO.write(image,"JPEG",new File("E:\\newimage.JPG"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file= new File("E:\\\\newimage.JPG");
        BufferedImage image=null;
        try {
         image= ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        AffineTransform tx = new AffineTransform();
        tx.rotate(2, image.getWidth() / 2, image.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);
        image = op.filter(image, null);
        try {
            ImageIO.write(image,"JPG",new File("E:\\\\newimage.JPG"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
