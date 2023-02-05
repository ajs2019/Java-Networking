import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Accepted connection from " + clientSocket.getInetAddress());
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            out.println("Received: " + inputLine);
        }

        clientSocket.close();
        serverSocket.close();
    }
}