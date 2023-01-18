package _18_01_2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx5 {

    public static void main(String[] args) {
        //1236 5478 9654 1258 12/54 (655)
        String card = "12365478965412581254655";
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(card);
        String cardString = matcher.replaceAll("$1 $2");
       // System.out.println(cardString);
    }
}