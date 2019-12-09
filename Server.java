import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException, ClassNotFoundException {

        Serialise ser = new Serialise();
        File dir = new File("C:\\Users\\owner\\Desktop\\distribsys\\common\\");
        ClientObservable observable = new ClientObservable();
        MyObserver observer = new MyObserver(dir);

        observable.addObserver(observer);
        observable.setCurrent(dir);
        observable.checkTemp(dir);
        ArrayList<SuperVillain> villains = observer.getVillains();
        System.out.println("No. of villains = " + villains.size());

        serverSocket = new ServerSocket(port);
        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Server running on port " + port);


            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(villains);

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ArrayList<SuperHero> heroes = (ArrayList<SuperHero>)in.readObject();

            System.out.println("Heroes length = " + heroes.size());
            for(int i=0; i<heroes.size(); i++){
                File newf = new File("C:\\Users\\owner\\Desktop\\distribsys\\common\\save-the-world-again\\saved"+(i+1)+".ser");
                ser.writeto(heroes.get(i),newf.toString());
            }

        }

    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.start(5555);
    }
}
