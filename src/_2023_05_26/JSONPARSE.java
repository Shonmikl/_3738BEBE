package _2023_05_26;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class JSONPARSE {
    public static void main(String[] args) throws IOException {
        try {
            InputStream inputStream
                    = JSONPARSE.class.getResourceAsStream("/ex.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject json = new JSONObject(stringBuilder.toString());
            Map<String, Object> map = json.toMap();

            for (String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
        } catch (Exception e) {
            System.out.println("Error reading and parsing JSON: " + e.getMessage());
        }
    }
}