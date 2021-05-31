package DemoSocket;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class test2 {
    public static void main(String[] args) {
        InetSocketAddress isa = new InetSocketAddress("192.168.0.106", 8888);
        System.out.println(isa);
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        System.out.println(isa.getAddress());
    }
}
