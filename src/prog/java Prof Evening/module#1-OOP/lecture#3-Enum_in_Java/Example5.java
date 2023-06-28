enum Season {
    WINTER("snow"),
    SPRING("green"),
    SUMMER("sun"),
    AUTUMN("rain");

    private String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class Example5 {
    public static void main(String[] args) {
        for (Season s : Season.values())
            System.out.println(s + " " + s.getValue());
    }
}