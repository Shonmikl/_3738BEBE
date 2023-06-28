import java.io.*;

public class Example2 {
    public static String codeFromSlide(String path) {

        BufferedReader br = null;
        String result = null;

        try {
            new BufferedReader(new FileReader(path));
            result = br.readLine();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
