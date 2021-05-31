package DemoLoginUpdate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer {
    public static void main(String[] args) {
        //创建一个套接字， 指定本侧的端口号
        System.out.println("--------------Sever Start----------");
        ServerSocket ss = null;
        Socket s =null;


        //定义一个计数， 用来计算有多少个用户访问
        int count = 0;
        try {
            ss = new ServerSocket(8888);
            //通过serverSocket获取服务器端的套接字
            while (true){
                s = ss.accept();//阻塞方法， 服务器在这里等着
                new ServerThread(s).start();
                count++;
                System.out.println("当前是第 "+count+" 个用户在访问, 用户的IP address是"+s.getInetAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
