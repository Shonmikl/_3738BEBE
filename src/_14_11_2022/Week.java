package _14_11_2022;

public enum Week {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("good"),
    SUNDAY("nice");

    private String mood;

    Week(String mood) {
        this.mood = mood;
    }
}