package spring.web.A;

import org.springframework.beans.factory.annotation.Autowired;
import spring.web.entity.UserEntity;
import spring.web.repo.UserRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassA {
   static int b;
    public ClassA(int c){
        b=c;


    }
    public static void Class(int c){
        b=c;


    }

    public void  toPrint(){
        System.out.println(b);
    }

    public  static void main(String[] args) {
    ClassA a= new ClassA(10);
    a.Class(12);
    Class(11);
    a.toPrint();

    }
    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap du lieeu cho c");
        b=scanner.nextInt();
    }
}
