package server;

import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServer {

    private ThreadExecution singleEx;
    public Socket socket;

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

    private void runSingleThread(){
        singleEx.execute();
    }

    public static void main(String[] args) {
        try {
            int port = 9999;

            System.out.println("Server is running...");
    
            //*create a server socket and wait for client's connection
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
    
            SingleThreadServer serverTCP =new SingleThreadServer();
            serverTCP.setSocket(socket);
            serverTCP.singleEx= new ThreadExecution();
            serverTCP.singleEx.setSocket(socket);
            serverTCP.runSingleThread();


            socket.close();
            serverSocket.close();
            System.out.println("Server is closed...");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
