import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            Logg.log("Server: " + bufferedReader.readLine());
        }
    }

}
