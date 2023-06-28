public class Example1 {
    public static void main(String[] args) {
        User testUser = new User();
        test(testUser);
        test2(testUser);
    }

    public static void test(User user) {
        System.out.println(user.getName());
        System.out.println(user.hashCode());
    }

    public static void test2(User user) {
        user = new User();
        test(user);
    }
}

class User {
    private String name = "User";

    public String getName() {
        return name;
    }
}