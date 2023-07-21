package utils;

public class JobApplication {
    private String site;
    private String date;
    private String dateAppliedTo;
    private String companyName;
    private String position;
    private boolean fulltimeContract;
    private int salary;
    private String companyWebsite;
    private String contactInfo;
    private String callBackDate;
    private String techStack;
    private String round1;
    private String round2;
    private String round3;
    private String finalRound;
    private String notes;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateAppliedTo() {
        return dateAppliedTo;
    }

    public void setDateAppliedTo(String dateAppliedTo) {
        this.dateAppliedTo = dateAppliedTo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isFulltimeContract() {
        return fulltimeContract;
    }

    public void setFulltimeContract(boolean fulltimeContract) {
        this.fulltimeContract = fulltimeContract;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getCallBackDate() {
        return callBackDate;
    }

    public void setCallBackDate(String callBackDate) {
        this.callBackDate = callBackDate;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getRound1() {
        return round1;
    }

    public void setRound1(String round1) {
        this.round1 = round1;
    }

    public String getRound2() {
        return round2;
    }

    public void setRound2(String round2) {
        this.round2 = round2;
    }

    public String getRound3() {
        return round3;
    }

    public void setRound3(String round3) {
        this.round3 = round3;
    }

    public String getFinalRound() {
        return finalRound;
    }

    public void setFinalRound(String finalRound) {
        this.finalRound = finalRound;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public JobApplication(String site, String date, String dateAppliedTo, String companyName, String position,
                          String fulltimeContract, String salary, String companyWebsite, String contactInfo,
                          String callBackDate, String techStack, String round1, String round2, String round3,
                          String finalRound, String notes) {
        this.site = site;
        this.date = date;
        this.dateAppliedTo = dateAppliedTo;
        this.companyName = companyName;
        this.position = position;
        this.fulltimeContract = Boolean.parseBoolean(fulltimeContract);
        this.salary = Integer.parseInt(salary);
        this.companyWebsite = companyWebsite;
        this.contactInfo = contactInfo;
        this.callBackDate = callBackDate;
        this.techStack = techStack;
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
        this.finalRound = finalRound;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "{" +
                "site='" + site + '\'' +
                ", date='" + date + '\'' +
                ", dateAppliedTo='" + dateAppliedTo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", fulltimeContract=" + fulltimeContract +
                ", salary=" + salary +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", callBackDate='" + callBackDate + '\'' +
                ", techStack='" + techStack + '\'' +
                ", round1='" + round1 + '\'' +
                ", round2='" + round2 + '\'' +
                ", round3='" + round3 + '\'' +
                ", finalRound='" + finalRound + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
