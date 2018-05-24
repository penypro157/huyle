package spring.web.B;

import spring.web.beans.Mail;
import spring.web.beans.SendMail;
import spring.web.beans.VerifyMail;

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
        int j=0;
        j=get();
        System.out.println(j);

    }
    public static int get(){
        int i=9;

        return i;
    }
}
