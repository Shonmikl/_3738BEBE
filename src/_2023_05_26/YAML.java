package _2023_05_26;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YAML {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream inputStream =
                YAML.class.getClassLoader()
                        .getResourceAsStream("app.yml");
        if(inputStream == null) {
            System.out.println("Could not find the file");
        }

        try {
            Map<String, Object> map = yaml.load(inputStream);
            System.out.println(map);
        } catch (Exception e) {
            System.out.println("Error parsing yaml: " + e.getMessage());
        }
    }
}
