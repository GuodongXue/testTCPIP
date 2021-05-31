package DemoLogin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        //创建一个套接字， 指定本侧的端口号
        System.out.println("--------------Sever Start----------");
        ServerSocket ss = new ServerSocket(8888);
        //通过serverSocket获取服务器端的套接字
        Socket s = ss.accept();//阻塞方法， 服务器在这里等着
        //对于服务器端，利用流来接受数据
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        User user = (User) ois.readObject();

        //校验一下
        String str  = null;
        if(user.getUsername().equals("lili")&&user.getPassword().equals(
                "123123")){
            str="Successfully login. Welcome back.";
        }else{
            str="Login failed.";
        }

        //服务器对客户端的响应
        s.shutdownInput();
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(str);

        //关闭流
        dos.close();
        os.close();

        ois.close();
        is.close();
        s.close();
        ss.close();
    }
}
