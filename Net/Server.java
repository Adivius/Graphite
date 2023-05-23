import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public int port;
    public ServerSocket serverSocket;
    public boolean running;
    public ArrayList<ServerListenerThread> listenerThreads = new ArrayList<>();
    public Server(int port){
        this.port = port;
        this.running = false;
    }


    public void run() throws IOException {
        this.running = true;
        serverSocket = new ServerSocket(port);
        Logg.log("Server started!");
        while (running){
            acceptSocket(serverSocket.accept());
        }
    }

    public void acceptSocket(Socket socket) throws IOException {
        ServerListenerThread listenerThread = new ServerListenerThread(this, socket);
        listenerThreads.add(listenerThread);
        listenerThread.start();
        this.onUserConnected(socket);
    }


    public void onMessageReceived(Socket socket, String message){

    }

    public void onUserConnected(Socket socket){

    }

    public void onUserDisconnected(Socket socket){

    }


}
