package ss17_threading.BaiTap.CreateSimpleThread;

public class NumberGenerator implements Runnable{
    public void run(){
        for (int i = 1; i <= 10; i++){
            System.out.println("Thread: " + Thread.currentThread().getName()
            + " - Number: " +i
                    + " - HashCode: " + this.hashCode());
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
