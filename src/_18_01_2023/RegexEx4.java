package _18_01_2023;

import java.util.regex.Pattern;

public class RegexEx4 {
    static void checkIp(String ip) {
        //Oxana
        String regex =
                "^(255\\.){2}\\d{3}\\.\\d{2}$";
        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));
    }

    static void checkIp1(String ip) {
        //Jelena
        String regex =
                "^255\\.255\\.\\d{3}\\.\\d{2}";
        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));
    }

    static void checkIp3(String ip) {
        //Mikhail
        String regex =
                "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));
    }

    public static void main(String[] args) {
        //0-255.0-255.0-255.0-255
        String ip1 = "255.255.120.10";
        String ip2 = "985.254.100.11";
//        checkIp(ip1);
//        checkIp(ip2);

//        checkIp1(ip1);
//        checkIp1(ip2);

        checkIp3(ip1);
        checkIp3(ip2);

    }
}
