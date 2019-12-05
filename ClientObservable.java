import java.io.File;
import java.util.Observable;

public class ClientObservable extends Observable {
    private File current;

    public void setCurrent(File current){
        this.current = current;
    }

    public void checkTemp(File temp){
        boolean check = false;
        if(temp.list().length>1){
            check =  true;
        }
        while (check=true){
            setChanged();
            notifyObservers();
            if(temp.list().length<2){
                check=false;
                System.out.println("The Battle is done");
                break;
            }
        }
    }
}
