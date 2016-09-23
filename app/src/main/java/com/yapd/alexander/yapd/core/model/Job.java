package com.yapd.alexander.yapd.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexander on 9/22/16.
 */

public class Job implements Parcelable {
    private String startDate;
    private String endDate;
    private String title;
    private Company company;
    private String description;

    public Job() {
        //
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        StringBuilder durationStringBuilder = new StringBuilder();
        if (!startDate.equals("") && !startDate.equals(null)) {
            durationStringBuilder.append(startDate);
            durationStringBuilder.append(" - ");
        }

        if (!endDate.equals("") && !endDate.equals(null)) {
            durationStringBuilder.append(endDate);
        }

        return durationStringBuilder.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (startDate != null ? !startDate.equals(job.startDate) : job.startDate != null)
            return false;
        if (endDate != null ? !endDate.equals(job.endDate) : job.endDate != null) return false;
        if (title != null ? !title.equals(job.title) : job.title != null) return false;
        if (company != null ? !company.equals(job.company) : job.company != null) return false;
        return description != null ? description.equals(job.description) : job.description == null;

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", title='" + title + '\'' +
                ", company=" + company +
                ", description='" + description + '\'' +
                '}';
    }

    protected Job(Parcel in) {
        startDate = in.readString();
        endDate = in.readString();
        title = in.readString();
        company = (Company) in.readValue(Company.class.getClassLoader());
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeString(title);
        dest.writeValue(company);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };
}