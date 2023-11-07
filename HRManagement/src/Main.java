import enums.Title;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Applicant applicant = new Applicant("Olivia", "Berlin", "Berlin", 500);
        System.out.println(applicant.isRelocationPreferred());
        List<String> skillsDeveloper = new ArrayList<>(List.of("Java", "API", "SQL" +
                "Spring Boot"));
        JobPosition jobPosition = new JobPosition(Title.SOFTWARE_DEVELOPER, "Java", 70000, 80000, "Tech");
        System.out.println(jobPosition.isWithinBudget(applicant));

    }
}
