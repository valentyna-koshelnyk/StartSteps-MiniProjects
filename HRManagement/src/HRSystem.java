import enums.Role;
import enums.StatusApplication;
import enums.StatusPosition;
import enums.Title;
import utils.CRUD;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HRSystem {
    CRUD Crud = new CRUD();
    List<JobPosition> jobPositions;
    List<Recruiter> recruiters;
    List<Applicant> applicants;
    List<JobPosition> openPositions;
    List<JobPosition>closedPositions;
    Map<Title, JobPosition> openPositionPerTitle;
    Map<Title, JobPosition> closedPositionPerTitle;


    public void addJobPosition(JobPosition jobPosition){
        Scanner sc = new Scanner(System.in);
        if (!jobPositions.contains(jobPosition) && jobPosition != null) {
            jobPositions.add(jobPosition);
        } else if (jobPositions.contains(jobPosition)){
            System.out.println("The job already exists. Would you like to update it?");
            String reply = sc.nextLine();
            if (reply.equalsIgnoreCase("Yes")){
                updateJobPosition(jobPosition, new JobPosition(Title.ACCOUNTANT, "To prepare annual reports", 10_000, 20_000, "TECH"));
            } else {
                System.out.println("Invalid operation");
        }
        }
    }
    public void updateJobPosition(JobPosition jobPosition, JobPosition newJobPosition){
        newJobPosition = new JobPosition(Title.ACCOUNTANT, "To prepare annual reports",
                10_000, 20_000, "TECH");
        CRUD.update(jobPositions, jobPosition, newJobPosition);
    }

    public void addRecruiter(Recruiter recruiter) {
        recruiters.add(recruiter);

    }
    public void addApplicant(Applicant applicant){
        applicants.add(applicant);

    }

    public int calculateNumApplicants(List<Applicant> applicants){
        return applicants.size();
    }

    public int calculateNumPositions(List<JobPosition> jobPositions){
        return jobPositions.size();
    }
    public int calculateRewiewedPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getStatusApplication() == StatusApplication.REVIEWED)
                .toList();
        return reviewedPositions.size();
    }
    public int calculatePendingPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getStatusApplication() == StatusApplication.PENDING)
                .toList();
        return reviewedPositions.size();
    }
    public int calculateApprovedPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getStatusApplication() == StatusApplication.APPROVED)
                .toList();
        return reviewedPositions.size();
    }
    public int calculateDeclinedPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getStatusApplication() == StatusApplication.DECLINED)
                .toList();
        return reviewedPositions.size();
    }
    public int calculateJunPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getRole() == Role.JUNIOR)
                .toList();
        return reviewedPositions.size();
    }

    public int calculateMiddlePositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getRole() == Role.MIDDLE)
                .toList();
        return reviewedPositions.size();
    }
    public int calculateSeniorPositions(List<JobPosition> jobPositions){
        List<JobPosition> reviewedPositions = jobPositions.stream()
                .filter(job -> job.getRole() == Role.SENIOR)
                .toList();
        return reviewedPositions.size();
    }

    public int calculateRecruiters(List<Recruiter> recruiters){
        return recruiters.size();
    }

    public int calculateOpenPositions(List<JobPosition> openPositions){
        return openPositions.size();
    }
    public int calculateClosedPositions(List<JobPosition>closedPositions){
        return closedPositions.size();
    }

    public Map<Title, JobPosition> addPositionPerTitle(Title title, JobPosition jobPosition) {
        if (jobPosition.getStatusPosition() == StatusPosition.OPEN) {
            openPositionPerTitle.put(title, jobPosition);
        } else {
            closedPositionPerTitle.put(title, jobPosition);
        }
        return openPositionPerTitle;
    }

    /* very hardcoded. Dreaming about putting hands on DataSet/ DataFrame (Apache Spark),
     as well special packages for generating reports :) */

    public void generateReports(Map<String, Integer> report) {
        report.put(("Total Number of Applicants"), calculateNumApplicants(applicants));
        report.put(("Total Number of Positions"), calculateNumPositions(jobPositions));
        report.put(("Number of Reviewed Positions"), calculateRewiewedPositions(jobPositions));
        report.put("Number of Pending positions", calculatePendingPositions(jobPositions));
        report.put("Number of Approved Positions", calculateApprovedPositions(jobPositions));
        report.put("Number of Junior Positions", calculateJunPositions(jobPositions));
        report.put("Number of Middle Positions", calculateMiddlePositions(jobPositions));
        report.put("Number of Senior Positions", calculateSeniorPositions(jobPositions));
        report.put("Total number of OPEN positions", calculateOpenPositions(jobPositions));
        report.put("Total number of CLOSED positions", calculateClosedPositions(jobPositions));
        writeReports();
    }

    public void writeReports(){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("/GeneratedResources/outputData.txt"))){
            Map<String, Integer> report = new HashMap<>();
            bf.write(report.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String readReports(){
    try(BufferedReader br = new BufferedReader(new FileReader("/GeneratedResources/outputData.txt"))){
        return br.lines()
                .collect(Collectors.joining(System.lineSeparator()));
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}

// a bit more complex reports on salary will come soon (interested in building salary report
// per industry/role/title;
