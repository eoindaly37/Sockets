import java.io.*;

public class Serialise implements Serializable {
    public void writeto(SuperPerson obj, String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (IOException e){
            System.out.println("file not found");
        }
    }
    public SuperVillain deserialise(File path){
        SuperVillain sv = null;
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sv = (SuperVillain) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e){
            System.out.println("\nNo villain yet\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sv;
    }
}
