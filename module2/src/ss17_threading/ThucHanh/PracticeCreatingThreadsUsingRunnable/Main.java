package ss17_threading.ThucHanh.PracticeCreatingThreadsUsingRunnable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread running... ");

        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-1-HR-Đatabase");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2-Sednd-Email");
        runnableDemo2.start();

        System.out.println("Main thread stopped!!! ");
    }
}
