import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    private int number;
    private ArrayList<SuperVillain> villains = new ArrayList<>();

    File dir;

    public MyObserver(File dir){
        this.dir = dir;
        this.number = 1;
    }

    @Override
    public void update(Observable o, Object arg) {
        File temp = new File("C:\\Users\\owner\\Desktop\\distribsys\\common\\bzi"+number+".ser");
        ThreadHero thread = new ThreadHero();
        /*
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */
        thread.run(temp,number,villains);
        number++;
    }
    public ArrayList<SuperVillain> getVillains(){
        return this.villains;
    }
}
