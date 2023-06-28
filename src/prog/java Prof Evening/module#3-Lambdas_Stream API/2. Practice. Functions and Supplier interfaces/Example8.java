import java.time.temporal.ValueRange;

public class Example8 {
    public static void main(String[] args) {
        HttpCodes.findValueByCode(101);
        HttpCodes.findValueByCode(202);
        HttpCodes.findValueByCode(303);
        HttpCodes.findValueByCode(404);
        HttpCodes.findValueByCode(505);
    }
}


enum HttpCodes {
    INFORMATIONAL(100, 199, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    SUCCESS(200, 299, (code,d) -> System.out.println("http code: " + code + ": " + d)),
    REDIRECTION(300, 399, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    CLIENT_ERROR(400, 499, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    SERVER_ERROR(500, 599, (code, d) -> System.out.println("http code: " + code + ": " + d));

    final int minCode;
    final int maxCode;
    final Action deistvie;

    HttpCodes(int minCode, int maxCode, Action action) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.deistvie = action;
    }

    public static void findValueByCode(int code) {
        for (HttpCodes v: HttpCodes.values()) {
            if (ValueRange.of(v.minCode, v.maxCode).isValidIntValue(code))
                v.doIt(code, v);
        }
    }

    public void doIt(int code, HttpCodes v) {
        if (deistvie != null)
            deistvie.action(code, v);
    }
}

@FunctionalInterface
interface Action {
    void action(int code, HttpCodes d);
}