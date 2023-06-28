import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("R");
        list1.add("o");
        list1.add("m");
        list1.add("a");
        list1.add("n");
        list1.add("R");
        list1.add("o");
        list1.add("m");
        list1.add("a");
        list1.add("n");

        System.out.println(list1);
        System.out.println(removeDuplicates(list1));
    }

    public static ArrayList<String> removeDuplicates(ArrayList<String> values) {
        ArrayList<String> noDuplicates = new ArrayList<>();

        for (String s: values) {
            if (!noDuplicates.contains(s))
                noDuplicates.add(s);
        }

        return noDuplicates;
    }
}
