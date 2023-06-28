import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Note -> Какой алгоритм сортировки использует Java в sort()?
Ранее sort() в Java использовал быструю сортировку для массивов примитивов и сортировку слиянием для массивов объектов.
В последних версиях Java метод Arrays.sort() и Collection.sort() используют Timsort.
TimSort алгоритм сспользует InsertionSort и MergeSort.
1. отсортировать небольшие фрагменты с помощью сортировки вставками
2. объедините фрагменты, используя сортировку слиянием
 */

public class Example6 {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1};
//        sortingViaCycle(arr);
//        sortingViaArraysSort(arr);
        sortingViaCollections(arr);
    }

    public static void sortingViaCycle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print(arr[i] + " ");
        }
    }

    /*
    Arrays.Sort() работает с массивами, которые могут иметь примитивный тип данных по умолчанию сортируются в порядке
    возрастания
     */
    public static void sortingViaArraysSort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Collections.sort() работает с объектами, такими как ArrayList и LinkedList
     */
    public static void sortingViaCollections(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
            list.add(arr[i]);

        Collections.sort(list);
        System.out.println(list);
    }

}
