import java.util.LinkedList;
import java.util.concurrent.Executor;

/**
 * Created by digibrose on 23/02/2015.
 */
public class SimpleEx implements Executor {

   JobList ExList;

    public SimpleEx(int i) {

        ExList = new JobList();

        for (int j = 0; j < i; j++) {
            Thread t = new Thread(ExList);
            t.start();
        }
    }

    @Override
    public void execute(Runnable command) {

        this.ExList.add(command);
    }
}
