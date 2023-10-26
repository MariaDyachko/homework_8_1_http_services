import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("netology.homework", Server.LOCALHOST_PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            //writer.println("Hello from 2");
            //System.out.println(reader.readLine());
            InputStreamReader letter = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(letter);
            String name = br.readLine();
            writer.println(name);
            String yesNo = br.readLine();
            writer.println(name);
        }
    }
}
