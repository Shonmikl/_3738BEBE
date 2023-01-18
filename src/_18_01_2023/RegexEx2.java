package _18_01_2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx2 {
    public static void main(String[] args) {
        String s = "ASFF_ ASDFGA,FH ASDFA7FGHA1F23JKLFAWF Ц";
        String s1 = "Mr Musk, who is being sued";
        //Pattern pattern = Pattern.compile("[ASDF]"); - любой из символов
        //Pattern pattern = Pattern.compile("A[SD]F"); - или S или D
        //Pattern pattern = Pattern.compile("A[A-Za-z]F"); - диапазон
        //Pattern pattern = Pattern.compile("ASDF"); - вся подстрока
        //Pattern pattern = Pattern.compile("A[^A-z1-5]F"); - ^ отрицание
        //Pattern pattern = Pattern.compile("A(S|7)F");
        //Pattern pattern = Pattern.compile("ASDF."); - . любой символ
        // \d - одна цифра
        // \w - буква цифра или _
        // \s - пробел
        //Pattern pattern = Pattern.compile("\\w{4}"); - повторения
        //\A - начало стринги
        //\Z - конец стринги
        //\b - граница слова или числа
        Pattern pattern = Pattern.compile("\\w{4}");
        Matcher matcher = pattern.matcher(s1);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}