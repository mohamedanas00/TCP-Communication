package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import server.math.MathParse;


public class ThreadExecution {
    public MathParse mathParse;
    public Socket socket ;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ThreadExecution() {
        this.mathParse =new MathParse();
    }

    public void execute(){
        try {
            System.out.println("In ServerSingleEx ");
            //*Read Message from Client */
            BufferedReader reader =new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
            );
            String message = reader.readLine();
            double result = mathParse.parseMessage(message);
           
            //*Send Result to Client */
            BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(this.socket.getOutputStream())
            );
			writer.write("Result :" + result);
			writer.newLine();
			writer.flush();

            writer.close();
            reader.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
