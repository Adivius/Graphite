import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public int port;
    public ServerListenerThread serverListenerThread;
    public ServerSocket serverSocket;
    public boolean running;


    public Server(int port){
        this.port = port;
        this.running = false;
    }


    public void run() throws IOException {
        this.running = true;
        serverSocket = new ServerSocket(port);
        Logg.log("Server started!");
        while (running){
            Socket socket = serverSocket.accept();
            Logg.log("+1");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello World");
            Logg.log("-1");
        }
    }

}
