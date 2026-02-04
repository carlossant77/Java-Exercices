public class Job implements Runnable {

    private final int id;

    public Job(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Processando job " + id +
                " na thread " + Thread.currentThread().getName());
    };

    public int getId() {
        return id;
    }

}
