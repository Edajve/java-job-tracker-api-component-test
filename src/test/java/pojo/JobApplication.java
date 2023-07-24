package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobApplication {
    private String id;
    private String site;
    private String date;
    private String date_applied_to;
    private String company_name;
    private String position;
    private boolean fulltime_contract;
    private int salary;
    private String company_website;
    private String contact_info;
    private String call_back_date;
    private String tech_stack;
    private String round_1;
    private String round_2;
    private String round_3;
    @JsonProperty("final")
    private String finalRound;
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDate_applied_to() {
        return date_applied_to;
    }

    public void setDate_applied_to(String date_applied_to) {
        this.date_applied_to = date_applied_to;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isFulltimeContract() {
        return fulltime_contract;
    }

    public void setFulltime_contract(boolean fulltime_contract) {
        this.fulltime_contract = fulltime_contract;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getCall_back_date() {
        return call_back_date;
    }

    public void setCall_back_date(String call_back_date) {
        this.call_back_date = call_back_date;
    }

    public String getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(String tech_stack) {
        this.tech_stack = tech_stack;
    }

    public String getRound_1() {
        return round_1;
    }

    public void setRound_1(String round_1) {
        this.round_1 = round_1;
    }

    public String getRound_2() {
        return round_2;
    }

    public void setRound_2(String round_2) {
        this.round_2 = round_2;
    }

    public String getRound_3() {
        return round_3;
    }

    public void setRound_3(String round_3) {
        this.round_3 = round_3;
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

    public JobApplication() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"site\":\"" + site + "\"," +
                "\"date\":\"" + date + "\"," +
                "\"date_applied_to\":\"" + date_applied_to + "\"," +
                "\"company_name\":\"" + company_name + "\"," +
                "\"position\":\"" + position + "\"," +
                "\"fulltime_contract\":" + fulltime_contract + "," +
                "\"salary\":" + salary + "," +
                "\"company_website\":\"" + company_website + "\"," +
                "\"contact_info\":\"" + contact_info + "\"," +
                "\"call_back_date\":\"" + call_back_date + "\"," +
                "\"tech_stack\":\"" + tech_stack + "\"," +
                "\"round_1\":\"" + round_1 + "\"," +
                "\"round_2\":\"" + round_2 + "\"," +
                "\"round_3\":\"" + round_3 + "\"," +
                "\"final\":\"" + finalRound + "\"," +
                "\"notes\":\"" + notes + "\"" +
                '}';
    }
}
