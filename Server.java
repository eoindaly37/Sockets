import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while(true){
            new EchoClientHandler(serverSocket.accept()).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread{
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket){
            this.clientSocket = socket;
        }

        public void run(){
            File dir = new File("C:\\Users\\owner\\Desktop\\distribsys\\common\\");
            ClientObservable observable = new ClientObservable();
            Client observer = new Client(dir);

            observable.addObserver(observer);
            observable.setCurrent(dir);
            observable.checkTemp(dir);
        }

        public static void main(String[] args) throws IOException {
            Server server = new Server();
            server.start(5555);
        }
    }
}
