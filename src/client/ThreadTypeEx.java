package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadTypeEx {
    private String IP;
    private int port;

    public ThreadTypeEx(String IP, int port) {
        this.IP = IP;
        this.port = port;
    }

    public void runSingleThread() {
        try {
            Socket socket = new Socket(IP ,port);
            //*Write message to server */
            BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String message = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message :");
            message = scanner.nextLine();

            writer.write(message);
            writer.newLine();
            writer.flush();

            //*Read the result from server */
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            
            reader.close();
            scanner.close();
            writer.close();
            socket.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    //*Send Multiple Requests in same time */
    public void runMultiThread(int count){
        for (int i = 0; i < count; i++) {
            try {
                Socket socket = new Socket(IP ,port);
                //*Write message to server */
                BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    
                writer.write("+:" + i + ":22");
                writer.newLine();
                writer.flush();
    
                //*Read the result from server */
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
                
                reader.close();
                writer.close();
                socket.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
