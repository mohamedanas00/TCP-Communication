import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket =new ServerSocket(6000);
            System.out.println("Server is Running, waiting for client...");
            Socket socket = serverSocket.accept();//*Block waiting client Request*/
            System.out.println("Accepts incoming client connections");

            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            String message ="";
            while (!message.equals("stop")) {
                message = dataInputStream.readUTF();
                System.out.println("New Message: "+ message);
            }
            System.out.println("Server Closing");
            dataInputStream.close();
            socket.close();
            serverSocket.close();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
}
