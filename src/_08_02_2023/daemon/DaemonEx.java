package _08_02_2023.daemon;

import _11_01_2023.fileReader.FileWriterEx;

import java.io.FileWriter;
import java.io.IOException;

public class DaemonEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN START");

        UT ut = new UT();
        ut.setName("USER-THREAD");

        DT dt = new DT();
        dt.setName("DAEMON_THREAD");
        dt.setDaemon(true);

        ut.start();
        dt.start();

        System.out.println("MAIN END");
    }
}

class UT extends Thread {

    @Override
    public void run() {
        System.out.println("UT CLASS [ " + Thread.currentThread().getName() + " ]");
        System.out.println("UT CLASS || IS DAEMON: [" + isDaemon() + "]");

        for (char i = 'A'; i <= '^'; i++) {
            try {
                sleep(800);
                System.out.println("CHAR: [" + i + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DT extends Thread {

    @Override
    public void run() throws RuntimeException {
        System.out.println("DT CLASS [ " + Thread.currentThread().getName() + " ]");
        System.out.println("DT CLASS IS DAEMON: [" + isDaemon() + "]");
        FileWriter writer = null;
        try  {
             writer = new FileWriter("dt.txt");
            for (int i = 0; i < 50; i++) {
                sleep(200);
                writer.write("INTEGER: [" + i + "]");
                System.out.println("INTEGER: [" + i + "]");
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}