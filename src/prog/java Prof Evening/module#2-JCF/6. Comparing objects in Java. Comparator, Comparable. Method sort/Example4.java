import java.util.Arrays;

/*
ИТОГ
Comparable делает наши объекты «сравнимыми» и создает для них наиболее естественный порядок сортировки, который будет
использоваться в большинстве случаев.
Comparator — это отдельный класс-«сравниватель», который сравнивает по другим характеристикам, которые мы указываем дополнительно.
 */

public class Example4 {
    public static void main(String[] args) {
        Pair[] arr = new Pair[4];

        arr[0] = new Pair("abc", 3);
        arr[1] = new Pair("a", 4);
        arr[2] = new Pair("bc", 5);
        arr[3] = new Pair("a", 6);

        System.out.println(Arrays.toString(arr));
    }
}

class Pair implements Comparable<Pair> {

    private String x;
    private int y;

    public Pair(String x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Pair o) {
        // if the string are not equal
        if (this.x.compareTo(o.x) != 0)
            return this.x.compareTo(o.x);
        else
            return this.y - o.y;
    }

    public String getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}