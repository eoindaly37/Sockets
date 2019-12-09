import java.awt.image.ImageObserver;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client{
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;


    public void startConnection(String ip, int port) throws IOException, ClassNotFoundException {
        clientSocket = new Socket(ip,port);
        System.out.println("Client connected");
        in = new ObjectInputStream(clientSocket.getInputStream());

        ArrayList<SuperVillain> villains = (ArrayList<SuperVillain>)in.readObject();
        System.out.println(villains.size());

        ArrayList<SuperHero> heroes = new ArrayList<>();
        StrongVillain strongVillain = new StrongVillain();
        FlyVillain flyVillain = new FlyVillain();
        for(int i=0; i<villains.size(); i++){
            SuperVillain sv = villains.get(i);
            if (sv==null){
                //do nothing
            }
            else if(sv.getClass().equals(flyVillain.getClass())){
                FlyHero fh = new FlyHero();
                heroes.add(fh);
                System.out.println("fly hero added");
            }
            else{
                StrongHero sh = new StrongHero();
                heroes.add(sh);
                System.out.println("strong hero added");
            }

        }
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        out.writeObject(heroes);
    }
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client();
        client.startConnection("127.0.0.1",5555);
    }
}
