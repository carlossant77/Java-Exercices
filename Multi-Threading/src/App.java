import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class App {

    static Queue<Job> queue = new LinkedList<>();

    public static int sorteio() {
        Random gen = new Random();

        int number = gen.nextInt(queue.size());
        return number;
    }

    private static synchronized Job returnJob() {
        return queue.poll();
    }

    public static void main(String[] args) {

        Thread builder = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Job job = new Job(i);

                queue.add(job);
            }
        });

        builder.start();

        Thread reader1 = new Thread(() -> {
            while (true) {
                Job currentJob = returnJob();
                if (currentJob != null) {
                    currentJob.run();
                }
                if (queue.isEmpty()) {
                    break;
                }
            }
        });

        Thread reader2 = new Thread(() -> {
            while (true) {
                Job currentJob = returnJob();
                if (currentJob != null) {
                    currentJob.run();
                }
                if (queue.isEmpty()) {
                    break;
                }
            }
        });

        reader1.start();
        reader2.start();

    }
}
