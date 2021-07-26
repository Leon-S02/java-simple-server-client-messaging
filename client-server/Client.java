import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        int port = 50000;
        String serverIP = "192.168.0.182";
        String message = "";

        Socket client = new Socket(serverIP, port);
        Scanner scan = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(client.getOutputStream());

        System.out.println("SUCCESSFULLY CONNECTED TO SERVER " + serverIP + " OVER PORT " + port);
        System.out.println("Type 'quit' to end connection.");


        while (!message.equalsIgnoreCase("quit")) {
            System.out.print("Enter message for server: ");
            message = scan.nextLine();
            writer.println(message);
            writer.flush();
        }
        System.out.println("CONNECTION ENDED SUCCESSFULLY.");
    }
}

