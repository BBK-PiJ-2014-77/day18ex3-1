import java.util.concurrent.Executor;

/**
 * Created by digibrose on 23/02/2015.
 */
public class TextLoop implements Runnable {

    public static final Integer COUNT = 10;
    private final String name;
    public TextLoop(String name) {
        this.name = name;
    }

    public static void main(String args[]) {

        if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
            System.out.println("USAGE: java TextLoop <mode>");
            System.out.println(" mode 0: without threads");
            System.out.println(" mode 1: with threads");
        } else if (args[0].equals("0")) {
            for (int i = 0; i < 10; i++) {

                Runnable r = new TextLoop("Thread " + i);
                r.run();
            }
        } else {
            Executor t = new SimpleEx(5);
            for (int i = 0; i < 10; i++) {
                Runnable r = new TextLoop("Thread " + i);
                t.execute(r);

            }

        }
    }

    @Override
    public void run() {
           synchronized (COUNT) {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Loop:" + name + ", iteration:" + i + ".");
        }
    }
    }

}
