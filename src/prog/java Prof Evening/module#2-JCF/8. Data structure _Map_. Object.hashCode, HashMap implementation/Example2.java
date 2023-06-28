import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Example2 {
    public static void main(String[] args) {
        HashMap<String, String> cityMap = new HashMap<>();

        cityMap.put("Berlin", "London");
        cityMap.put("Tokyo", "Seoul");
        cityMap.put("Mumbai", "Berlin");
        cityMap.put("Seoul", "Mumbai");
        cityMap.put("London", "Helsinki");

        System.out.println(cityMap);

        getRoute(cityMap);
    }

    public static void getRoute(HashMap<String, String> cityMap) {
        HashMap<String, String> reverseMap = new HashMap<>();

        for (Map.Entry<String, String> entry : cityMap.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());

        System.out.println(reverseMap);

        String start = null;

        for (Map.Entry<String, String> entry : cityMap.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }

        // if start still equals null
        if (start == null)
            throw new NoSuchElementException("Invalid route, no start point");

        System.out.println(start);

        String toCity = cityMap.get(start);

        while (toCity != null) {
            System.out.print(start + " -> " + toCity + ", ");
            start = toCity;
            toCity = cityMap.get(toCity);
        }
    }
}
