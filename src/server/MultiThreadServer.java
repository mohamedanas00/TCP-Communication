package server;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer extends ThreadExecution implements Runnable {

    
    @Override
    public void run() {
        execute();
    }

    public static void main(String[] args) {
        try {
            int port = 9999;
            System.out.println("Multi Threaded Server started...");
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                	//*Waiting for client connection
                	Socket socket = serverSocket.accept();
                	socket.setSoTimeout(20000);
                    MultiThreadServer serverMultiThread = new MultiThreadServer();
                    serverMultiThread.setSocket(socket);
                    serverMultiThread.run();
                	//*start a new server thread...
                	Thread t = new Thread(serverMultiThread);
                	t.start();
                	System.out.println("Thread #" + t.getId());
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    
    
}
