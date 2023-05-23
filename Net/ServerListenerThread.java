import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerListenerThread extends Thread {

    public Server server;
    public Socket socket;
    public PrintWriter printWriter;
    public BufferedReader bufferedReader;

    public ServerListenerThread(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
    }


    @Override
    public void run() {

        try {
            while (!socket.isClosed()) {
                this.printWriter = new PrintWriter(socket.getOutputStream(), true);
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = bufferedReader.readLine();
                server.onMessageReceived(socket, message);
            }

            printWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
