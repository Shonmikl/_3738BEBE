package _18_01_2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx5 {

    public static void main(String[] args) {
        String card = "12365478965412581254655";
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(card);
        String cardString = null;
        System.out.println(cardString);
    }
}
