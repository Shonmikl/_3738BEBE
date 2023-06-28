import java.util.Enumeration;
import java.util.Vector;

/*
пример Enumeration

Унаследованные классы (Legacy Classes) Collection Framework – это классы языка Java 1.0/1.1.
List - Vector, Stack
Map - Dictionary, Hashtable, Properties
 */

public class Example2 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector();

        for (int i = 0; i < 10; i++) {
            v.addElement(i);
        }

        System.out.println(v);
        Enumeration<Integer> e = v.elements();

        while (e.hasMoreElements()) {
            int i = e.nextElement();
            System.out.print(i + " ");
        }
    }
}
