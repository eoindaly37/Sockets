import java.io.File;
import java.util.ArrayList;

public class ThreadHero extends Thread{
    public void run(File temp, int number, ArrayList<SuperVillain> villains){
        Serialise ser = new Serialise();
        SuperVillain sv = ser.deserialise(temp);
        StrongVillain strongVillain = new StrongVillain();
        FlyVillain flyVillain = new FlyVillain();
        if (sv==null){
            //do nothing
        }
        else if(sv.getClass().equals(flyVillain.getClass())){
            System.out.println("Fly Villain found");
            villains.add(sv);
            System.out.println("Fly villain added to server");
            temp.delete();
            System.out.println("Fly Villain deleted");
        }
        else{
            System.out.println("Strong Villain found");
            villains.add(sv);
            System.out.println("Strong villain added to server");
            temp.delete();
            System.out.println("Fly Villain deleted");
        }
    }
}
