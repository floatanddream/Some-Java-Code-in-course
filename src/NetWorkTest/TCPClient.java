package NetWorkTest;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[]a) throws Exception {
        Socket socket=new Socket("127.0.0.1",9060);
        OutputStream os=socket.getOutputStream();
        PrintStream ps=new PrintStream(os);
        ps.println("TCP CLIENT");
        ps.flush();
    }
}
