import java.net.Socket;
import java.io.DataOutputStream;
import java.util.*;
public class clientTCP {
    public static void main(String[] args) throws Exception {
        try {
            Socket socket= new Socket("127.0.0.1",6000);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());//!IF Server is not running will throw ex//
            System.out.println("Enter Message: ");
            Scanner scanner =new Scanner(System.in);
            String message = "";
            
            do {
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message); 
                dataOutputStream.flush();
            } while (!message.equals("stop"));
			scanner.close();
            dataOutputStream.close();
            socket.close();
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
			     //*getOutputStream() method returns an output stream associated with this socket, 
                    //*which allows the program to send data to the other end of the connection. */