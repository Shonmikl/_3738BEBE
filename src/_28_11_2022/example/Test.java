package _28_11_2022.example;

public class Test {
    public static void main(String[] args) {
        School school1 = new School("Oxana", 16);
        School school2 = new School("Konstantin", 15);
        School school3 = new School("Alexandr", 15);
        School school4 = new School("Svitlana", 15);

        Student student1 = new Student("Jelena", 20);
        Student student2 = new Student("Alexey", 21);

        Employee employee1 = new Employee("Pavel", 30);
        Employee employee2 = new Employee("Sergey", 31);

        Team<School> schoolTeam1 = new Team("School Team1");
        Team<School> schoolTeam2 = new Team("School Team2");
        Team<Student> studentTeam2 = new Team<>("Student Team1");
        Team<Student> studentTeam1 = new Team<>("Student Team2");
        Team<Employee> employeeTeam2 = new Team<>("Employee Team1");
        Team<Employee> employeeTeam1 = new Team<>("Employee Team2");

        schoolTeam1.addNewParticipant(school1);
        schoolTeam1.addNewParticipant(school2);
        schoolTeam2.addNewParticipant(school3);
        schoolTeam2.addNewParticipant(school4);

        studentTeam1.addNewParticipant(student1);
        studentTeam1.addNewParticipant(student2);

        employeeTeam1.addNewParticipant(employee1);
        employeeTeam1.addNewParticipant(employee2);

        schoolTeam1.playWith(schoolTeam2);
    }
}