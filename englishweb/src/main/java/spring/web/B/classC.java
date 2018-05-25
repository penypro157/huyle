package spring.web.B;

import spring.web.beans.Mail;
import spring.web.beans.SendMail;
import spring.web.beans.VerifyMail;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class classC  {
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
        Date date =new Date();
        System.out.println(date.toString());
        String s= new SimpleDateFormat("dd-MM-yyyy").format(date);
        System.out.println(s);

    }

}
