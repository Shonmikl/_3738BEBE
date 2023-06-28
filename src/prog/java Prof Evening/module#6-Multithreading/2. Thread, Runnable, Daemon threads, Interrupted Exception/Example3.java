public class Example3 extends Thread {
    public void run(){

        if (Thread.currentThread().isDaemon()) {

            //checking for daemon thread
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }

    public static void main(String[] args) {
        //creating threads
        Example3 t1=new Example3();
        Example3 t2=new Example3();
        Example3 t3=new Example3();

        // now t1 is daemon thread
        t1.setDaemon(true);

        // starting threads
        t1.start();
        t2.start();
        t3.start();
    }
}
