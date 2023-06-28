public class Example7 {

    public int sum(int x, int y) {
        return (x + y);
    }

    public int sum(int x, int y, int z) {
        return (x + y + z);
    }

    public double sum(double x, double y) {
        return (x + y);
    }

    public static void main(String[] args) {
        Example7 example7 = new Example7();
        System.out.println(example7.sum(1,2));
        System.out.println(example7.sum(1,2, 3));
        System.out.println(example7.sum(1.3,2.0));
    }
}
