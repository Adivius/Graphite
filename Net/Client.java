import java.io.*;
import java.net.Socket;

public class Client {

    public int port;
    public String ip;
    public Socket socket;

    public Client(int port, String ip){
        this.port = port;
        this.ip = ip;
    }

    public void connect() throws IOException {
        this.socket = new Socket(this.ip, this.port);

        Logg.log("Connected!");
        Logg.log("Disconnected!");
        while (true){
            new PrintWriter(socket.getOutputStream(), true).println("Test2");
        }
    }

}
