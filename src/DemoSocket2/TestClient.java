package DemoSocket2;

import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------Client Start----------");

        //创建socket， 用来发送请求的， 指定服务器的ip和端口号
        Socket s = new Socket("localhost", 8848);
        //对于客户端， 我们直观的感受就是用流发送数据
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好呀");

        //客户端接收服务器端数据
        s.shutdownOutput();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println("Server said : "+dis.readUTF());
        //关闭流， 关闭socket
        dos.close();
        os.close();
        s.close();
    }
}
