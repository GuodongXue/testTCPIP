package DemoLoginUpdate;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        System.out.println("--------------Client Start----------");

        //创建socket， 用来发送请求的， 指定服务器的ip和端口号
        Socket s = null;
        OutputStream os=null;
        ObjectOutputStream oos= null;
        InputStream is = null;
        DataInputStream dis = null;


        try {
            s = new Socket("localhost", 8888);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input username");
            String username = sc.next();
            System.out.println("Please input password");
            String password = sc.next();
            //将账号密码封装成user对象
            User user = new User(username, password);

            //对于客户端， 我们直观的感受就是用流发送数据
            os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(user);

            //客户端接收服务器端数据
            s.shutdownOutput();
            is = s.getInputStream();
            dis = new DataInputStream(is);
            System.out.println(dis.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流， 关闭socket
            try {
                if(dis!=null){
                dis.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(oos!=null){
                oos.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os!=null){
                os.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(s!=null){
                s.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
