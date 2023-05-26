package _2023_05_26;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YAMLLIST {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        try {
            FileInputStream inputStream = new FileInputStream("app.yml");
            Map<String, Object> data = yaml.load(inputStream);
            List<String> ymlList = flatYaml(data);
            System.out.println(ymlList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> flatYaml(Map<String, Object> data) {
        List<String> flattenedList = new ArrayList<>();
        flatYaml("", data, flattenedList);
        return flattenedList;
    }

    @SuppressWarnings("uncheked")
    private static void flatYaml(String prefix, Map<String, Object> data, List<String> flattenedList) {
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map) {
                flatYaml(prefix + key + ".", (Map<String, Object>) value, flattenedList);
            } else {
                String valueString = (value != null) ? value.toString() : "null";
                flattenedList.add(prefix + key + ": " + valueString);
            }
        }
    }
}
