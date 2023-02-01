package _01_02_2023.intro;

public class Ex5 {
    public static void main(String[] args) {
        ThreadName threadName = new ThreadName();

        threadName.setName("SERVER");
        threadName.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Thread name is: " + threadName.getName());
        System.out.println("Priority is: " + threadName.getPriority());
    }
}

class ThreadName extends Thread {

}
