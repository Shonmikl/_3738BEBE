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
    private String mood1;

    Week(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}

class Today {
    Week week;

    public Today(Week week) {
        this.week = week;
    }

    void getDay() {
        switch (week) {
            case MONDAY,
                    THURSDAY,
                    TUESDAY,
                    FRIDAY,
                    WEDNESDAY -> System.out.println("Study JAVA");
            case SATURDAY,
                    SUNDAY -> System.out.println("RELAX");
        }
        System.out.println(week.getMood());
    }
}