import java.util.LinkedList;

/**
 * Created by digibrose on 23/02/2015.
 */
public class JobList implements Runnable {

    LinkedList<Runnable> Jobs;

    public JobList() {

        this.Jobs = new LinkedList<Runnable>();

    }

    public void add(Runnable Job){
        Jobs.add(Job);
    }


    @Override
    public void run() {
        while (!Jobs.isEmpty()){
            Runnable next = Jobs.poll();
            next.run();
    }
    }
}
