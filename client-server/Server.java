import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 50000;
        String message;

        ServerSocket server = new ServerSocket(port);
        System.out.println("SERVER ONLINE");

        Socket client = server.accept();
        InetAddress clientIP = client.getInetAddress();
        System.out.println("CLIENT CONNECTED" + clientIP);

        InputStreamReader input = new InputStreamReader(client.getInputStream());
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            message = reader.readLine();

            if (message.equalsIgnoreCase("quit")){
                break;
            }

            System.out.println("Client: " + message);
        }

        System.out.println("Client ended connection.");
        client.close();
    }
}

