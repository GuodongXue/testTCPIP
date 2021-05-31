package DemoSocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    //InetAddress
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia1 = InetAddress.getByName("192.168.0.106");
        System.out.println(ia1);
        System.out.println(ia1.getHostName());
        System.out.println(ia1.getHostAddress());

        InetAddress ia2 = InetAddress.getByName("GuodongPC");
        System.out.println(ia2);
        System.out.println(ia2.getHostName());
        System.out.println(ia2.getHostAddress());

        InetAddress ia3 = InetAddress.getByName("localhost");
        System.out.println(ia3);
        System.out.println(ia3.getHostName());
        System.out.println(ia3.getHostAddress());

        InetAddress ia4 = InetAddress.getByName("127.0.0.1");
        System.out.println(ia4);
        System.out.println(ia4.getHostName());
        System.out.println(ia4.getHostAddress());
    }
}
