package _18_01_2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx1 {
    public static void main(String[] args) {
        String s = "Mr Musk, who is being sued " +
                "by Tesla shareholders arguing " +
                "he manipulated@gamil.com the firm's share price, " +
                "has said he cannot 29 get a fair trial in San Francisco.\n" +
                "\n" +
                "He wanted the trial 654 to take place in Texas " +
                "- where he has moved Tesla's headquarters - " +
                "but that was reje1cted@gmail.ru . 987654";

        String v = "ABABBBDDBABABABBAsssbaABAB";

        //Pattern -> regex
        //Matcher -> String <-> Pattern
        //\A - начало стринги
        //\Z - конец стринги
        //\b - граница слова или числа
        //Pattern pattern = Pattern.compile("\\b\\d{3}");
        //Pattern pattern = Pattern.compile("\\w+@\\w+\\.(com|ru)");
        //Pattern pattern = Pattern.compile("A(B)?"); - или есть или нет
        //Pattern pattern = Pattern.compile("A(B)*");
        //Pattern pattern = Pattern.compile("\\AABW");
        Pattern pattern = Pattern.compile("ABQ\\Z");
        Matcher matcher = pattern.matcher(v);


        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
