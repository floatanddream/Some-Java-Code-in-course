package NetWorkTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[]a) throws Exception {
        ServerSocket ss=new ServerSocket(9060);
        while (true) {
        Socket sk=ss.accept();
        InputStream Input=sk.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(Input));
        String message;

            if ((message = br.readLine()) != null) {
                System.out.println(message);
            }
        }
    }
}
