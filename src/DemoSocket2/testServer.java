package DemoSocket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer {
    public static void main(String[] args) throws IOException {
        //创建一个套接字， 指定本侧的端口号
        System.out.println("--------------Sever Start----------");
        ServerSocket ss = new ServerSocket(8848);
        //通过serverSocket获取服务器端的套接字
        Socket s = ss.accept();//阻塞方法， 服务器在这里等着
        //对于服务器端，利用流来接受数据
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("The client: "+str);

        //服务器对客户端的响应
        s.shutdownOutput();
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Nice to meet you");

        //关闭流
        dis.close();
        is.close();
        s.close();
        ss.close();
    }
}
