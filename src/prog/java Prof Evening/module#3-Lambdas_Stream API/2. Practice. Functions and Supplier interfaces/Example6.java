import java.util.function.Function;

public class Example6 {
    public static void main(String[] args) {

        // С помощью класса Handler
//        Handler a = new Handler();
//        String result = a.apply(new Request("all ok", 123));
//        System.out.println(result);

        // уже известными способами
        Function<Request, String> func = (s) -> "Message is " + s.getMessage() + ", number is " + s.getNumber();
        System.out.println(func.apply(new Request("all ok", 345)));
    }
}


class Request {
    private String message;
    private int number;

    public Request(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class Handler implements Function<Request, String> {
    @Override
    public String apply(Request request) {
        return String.format("Message is %s, number is %d",
                request.getMessage(),
                request.getNumber());
    }
}