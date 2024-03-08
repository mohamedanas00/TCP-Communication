package client;

public class ClientTCP extends ThreadTypeEx {

    public ClientTCP(String IP, int port) {
        super(IP, port);
    }

    public static void main(String[] args) {
        ClientTCP client = new ClientTCP("localhost",9999);
        //  client.runSingleThread();
        client.runMultiThread(8);

    }
}
