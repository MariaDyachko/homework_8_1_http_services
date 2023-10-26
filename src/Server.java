import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer LOCALHOST_PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)) {
            System.out.println("Сервер стартанул");
            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    //String line = reader.readLine();
                    //System.out.println("Информация от клиента: " + line);
                    //writer.println(client.getPort());
                    writer.println("Write your name");
                    String name = reader.readLine();
                    writer.println("Are you child? (yes/no)");
                    String yesNo = reader.readLine();
                    switch (yesNo) {
                        case "yes":
                            writer.println("Welcome to the kids area, " + name + "! Let's play!");
                            break;
                        case "no":
                            writer.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                        default:
                            writer.println("good luck" + name + "!");
                            break;
                    }
                }
            }

        }
    }

}
