package Builders;

import utils.JobApplication;

public class ApplicationBuilder {
    private String id;
    private String site;
    private String date;
    private String date_applied_to;
    private String company_name;
    private String position;
    private boolean fulltime_contract;
    private String salary;
    private String company_website;
    private String contact_info;
    private String call_back_date;
    private String tech_stack;
    private String round_1;
    private String round_2;
    private String round_3;
    private String finall;
    private String notes;

    public ApplicationBuilder setid(String id) {
        this.id = id;
        return this;
    }

    public ApplicationBuilder setSite(String site) {
        this.site = site;
        return this;
    }

    public ApplicationBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public ApplicationBuilder setDate_applied_to(String date_applied_to) {
        this.date_applied_to = date_applied_to;
        return this;
    }

    public ApplicationBuilder setCompany_name(String company_name) {
        this.company_name = company_name;
        return this;
    }

    public ApplicationBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public ApplicationBuilder setFulltime_contract(boolean fulltime_contract) {
        this.fulltime_contract = fulltime_contract;
        return this;
    }

    public ApplicationBuilder setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public ApplicationBuilder setCompany_website(String company_website) {
        this.company_website = company_website;
        return this;
    }

    public ApplicationBuilder setContact_info(String contact_info) {
        this.contact_info = contact_info;
        return this;
    }

    public ApplicationBuilder setCall_back_date(String call_back_date) {
        this.call_back_date = call_back_date;
        return this;
    }

    public ApplicationBuilder setTech_stack(String tech_stack) {
        this.tech_stack = tech_stack;
        return this;
    }

    public ApplicationBuilder setRound_1(String round1) {
        this.round_1 = round1;
        return this;
    }

    public ApplicationBuilder setRound_2(String round2) {
        this.round_2 = round2;
        return this;
    }

    public ApplicationBuilder setRound_3(String round3) {
        this.round_3 = round3;
        return this;
    }

    public ApplicationBuilder setFinall(String finall) {
        this.finall = finall;
        return this;
    }

    public ApplicationBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public JobApplication build() {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setSite(site);
        jobApplication.setDate(date);
        jobApplication.setDate_applied_to(date_applied_to);
        jobApplication.setCompany_name(company_name);
        jobApplication.setPosition(position);
        jobApplication.setFulltime_contract(fulltime_contract);
        jobApplication.setSalary(Integer.parseInt(salary));
        jobApplication.setCompany_website(company_website);
        jobApplication.setContact_info(contact_info);
        jobApplication.setCall_back_date(call_back_date);
        jobApplication.setTech_stack(tech_stack);
        jobApplication.setRound_1(round_1);
        jobApplication.setRound_2(round_2);
        jobApplication.setRound_3(round_3);
        jobApplication.setFinalRound(finall);
        jobApplication.setNotes(notes);

        return jobApplication;
    }
}