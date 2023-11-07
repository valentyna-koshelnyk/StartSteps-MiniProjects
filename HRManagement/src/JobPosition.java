import enums.Role;
import enums.StatusApplication;
import enums.StatusPosition;
import enums.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
public class JobPosition {
    public void setTitle(Title title) {
        this.title = title;
    }
    private Role Role;
    private Title title;
    Map<JobPosition, Applicant> jobPositionApplicantMap = new HashMap<>();

    public Map<JobPosition, Applicant> addJobPositionMap(JobPosition jobPosition, Applicant applicant){
        return (Map<JobPosition, Applicant>) jobPositionApplicantMap.put(jobPosition, applicant);
    }
    public StatusApplication getStatusApplication() {
        return statusApplication;
    }
    public void setStatusApplication(StatusApplication statusApplication) {
        this.statusApplication = statusApplication;
    }

    private StatusApplication statusApplication;
    private Role role;
    private Title title;
    private List<String> requiredSkills = new ArrayList<>();
    private String location;

    public StatusPosition getStatusPosition() {
        return statusPosition;
    }

    public void setStatusPosition(StatusPosition statusPosition) {
        this.statusPosition = statusPosition;
    }
    public List<JobPosition> openPositions = new ArrayList<>();

    private StatusPosition statusPosition;

    public JobPosition(Title accountant, String toPrepareAnnualReports, int i, int i1, String tech) {
    }

    private String description;
    private double offeredSalaryRangeStart;
    private double offeredSalaryRangeEnd;
    public Title getTitle() {
        return title;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    private String industry;

    public Role getRole() {
        return role;
    }
    public Role getRole(Role role) {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOfferedSalaryRangeStart() {
        return offeredSalaryRangeStart;
    }

    public void setOfferedSalaryRangeStart(double offeredSalaryRangeStart) {
        this.offeredSalaryRangeStart = offeredSalaryRangeStart;
    }

    public double getOfferedSalaryRangeEnd() {
        return offeredSalaryRangeEnd;
    }

    public void setOfferedSalaryRangeEnd(double offeredSalaryRangeEnd) {
        this.offeredSalaryRangeEnd = offeredSalaryRangeEnd;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public JobPosition(Title title, String description, double offeredSalaryRangeStart, double offeredSalaryRangeEnd, String industry, StatusPosition statusPosition) {
        this.description = description;
        this.offeredSalaryRangeStart = offeredSalaryRangeStart;
        this.offeredSalaryRangeEnd = offeredSalaryRangeEnd;
        this.industry = industry;
        this.requiredSkills = requiredSkills;
        this.location = location;
        this.title = title;
        this.statusPosition =statusPosition;
    }
    public List<JobPosition> addOpenPositionList(List<JobPosition> positions){
        for (JobPosition myType : positions) {
                if (myType.getStatusPosition().equals(StatusPosition.OPEN)) {
                    openPositions.add(myType);
                }
            }
        }
        public List<JobPosition> addClosedPositionList(List<JobPosition> positions){
        for (JobPosition myType : positions) {
                if (myType.getStatusPosition().equals(StatusPosition.CLOSED)) {
                    openPositions.add(myType);
                }
            }
        }

        public boolean isWithinBudget(Applicant applicant) {
            if (offeredSalaryRangeStart > 0.0 && offeredSalaryRangeStart < offeredSalaryRangeEnd && applicant.getExpectedSalary() > 0.0) {
                List<Integer> salaryRange = IntStream.rangeClosed((int) offeredSalaryRangeStart, (int) offeredSalaryRangeEnd)
                       .boxed()
                        .toList();
                return salaryRange.contains(applicant.getExpectedSalary()) || applicant.getExpectedSalary() < offeredSalaryRangeStart &&;
             } else {
                 System.out.println("Invalid Number");
                }
    }
}
