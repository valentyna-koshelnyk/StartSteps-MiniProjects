import enums.Industry;
import enums.StatusApplication;
import enums.Role;
import utils.CRUD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class Recruiter {
    private CRUD CRUD = new CRUD();
    private String name;
    private List<JobPosition> jobPositionsManaged;
    private Set<String> specializedIndustries;
    private Set<String> specializedRoles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobPosition> getJobPositionsManaged() {
        return jobPositionsManaged;
    }

    public void setJobPositionsManaged(List<JobPosition> jobPositionsManaged) {
        this.jobPositionsManaged = jobPositionsManaged;
    }

    public Set<String> getSpecializedIndustries() {
        return specializedIndustries;
    }

    public void setSpecializedIndustries(Set<String> specializedIndustries) {
        this.specializedIndustries = specializedIndustries;
    }

    public Set<String> getSpecializedRoles() {
        return specializedRoles;
    }

    public void setSpecializedRoles(Set<String> specializedRoles) {
        this.specializedRoles = specializedRoles;
    }

    public Map<Recruiter, JobPosition> getRecruiterJobPositionMap() {
        return recruiterJobPositionMap;
    }

    public void setRecruiterJobPositionMap(Map<Recruiter, JobPosition> recruiterJobPositionMap) {
        this.recruiterJobPositionMap = recruiterJobPositionMap;
    }
    Map<Recruiter, JobPosition> recruiterJobPositionMap = new HashMap<>();
    public Recruiter(String name, List<JobPosition> jobPositionsManaged, Set<String> specializedIndustries, Set<String> specializedRoles) {
        this.name = name;
        this.jobPositionsManaged = jobPositionsManaged;
        this.specializedIndustries = specializedIndustries;
        this.specializedRoles = specializedRoles;
    }
    public void assignJobPosition(JobPosition jobPosition){
        recruiterJobPositionMap.put(this, jobPosition);
    }
    public void reviewApplicant(Applicant applicant){
        CRUD.read(applicant);
        applicant.setStatus(StatusApplication.REVIEWED);
    }
    public void addSpecializedIndustry(Industry industry){
        specializedIndustries.add(String.valueOf(industry));
    }
    public void addSpecializedRoles(Role role){
        specializedRoles.add(String.valueOf(role));
    }
    public boolean isSpecializedFor(JobPosition jobPosition){
      return (jobPositionsManaged.contains(jobPosition.getTitle()) || specializedIndustries.contains(jobPosition.getIndustry()))
                && specializedRoles.contains(jobPosition.getRole());

    }
}
