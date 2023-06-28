// алгоритм бинарного поиска, рекурсивная реализация
// работает только для отсортированного массива
public class Example5 {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,111,121};
        System.out.println(binarySearch(a, 0, a.length, 111));

    }

    public static int binarySearch(int[] arr, int leftIdx, int rightIdx, int element) {
        if (rightIdx >= leftIdx) {

            int mid = leftIdx + (rightIdx - leftIdx) / 2;

            if (arr[mid] == element)
                return mid;

            if (arr[mid] > element)
                return binarySearch(arr, leftIdx, mid - 1, element);

            return binarySearch(arr, mid + 1, rightIdx, element);
        }

        return -1;
    }
}
