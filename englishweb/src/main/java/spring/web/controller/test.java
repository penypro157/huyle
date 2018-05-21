//package spring.web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import javax.websocket.DeploymentException;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.Scanner;
//
//public class test {
//
//    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException {
//        MyClientEndpoint client = new MyClientEndpoint();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter something to send to Server:");
//        while(true) {
//            String message = sc.nextLine();
//            if (message.equals("close")) {
//                client.disconnect();
//                break;
//            }
//            client.sendMessage(message);
//        }
//        sc.close();
//    }
//}
