package com.yapd.alexander.yapd.core.model;

/**
 * Created by alexander on 9/22/16.
 */
public class Job {
    private String startDate;
    private String endDate;
    private String jobTitle;
    private Company company;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (startDate != null ? !startDate.equals(job.startDate) : job.startDate != null)
            return false;
        if (endDate != null ? !endDate.equals(job.endDate) : job.endDate != null) return false;
        if (jobTitle != null ? !jobTitle.equals(job.jobTitle) : job.jobTitle != null) return false;
        return company != null ? company.equals(job.company) : job.company == null;

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", company=" + company +
                '}';
    }
}
