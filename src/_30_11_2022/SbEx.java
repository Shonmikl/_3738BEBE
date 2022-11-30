package _30_11_2022;

public class SbEx {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Hello");
        System.out.println(builder);
        builder.append("!");
        builder.append("?");
        System.out.println(builder);
        builder.append("*")
                .append("^^")
                .append("##");
        System.out.println(builder);
        builder.trimToSize();

        StringBuffer stringBuffer = new StringBuffer("StringBuffer");
    }
}