package NetWorkTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveUDp {
    ReceiveUDp() throws Exception {
        DatagramSocket dgs=new DatagramSocket();
        String str="JAVAS";
        DatagramPacket dgp=new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("127.0.0.1"),9010);
        dgs.receive(dgp);
        System.out.println(dgs.getBroadcast()+str);
    }
}
