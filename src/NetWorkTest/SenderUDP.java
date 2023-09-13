package NetWorkTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket dgs=new DatagramSocket();
        String str="JAVAS";
        DatagramPacket dgp=new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("127.0.0.1"),9010);
        ReceiveUDp uDP=new ReceiveUDp();
        dgs.send(dgp);
        dgs.close();
    }
}
