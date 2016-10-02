package com.yapd.alexander.yapd.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexander on 9/29/16.
 */
public class Venture implements Parcelable {
    private String description;
    private String problem;
    private String solution;
    private String monetization;
    private String lesson;
    private Company company;

    public Venture() {
        //
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getMonetization() {
        return monetization;
    }

    public void setMonetization(String monetization) {
        this.monetization = monetization;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
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

        Venture venture = (Venture) o;

        if (description != null ? !description.equals(venture.description) : venture.description != null)
            return false;
        if (problem != null ? !problem.equals(venture.problem) : venture.problem != null)
            return false;
        if (solution != null ? !solution.equals(venture.solution) : venture.solution != null)
            return false;
        if (monetization != null ? !monetization.equals(venture.monetization) : venture.monetization != null)
            return false;
        if (lesson != null ? !lesson.equals(venture.lesson) : venture.lesson != null) return false;
        return company != null ? company.equals(venture.company) : venture.company == null;

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (problem != null ? problem.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (monetization != null ? monetization.hashCode() : 0);
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Venture{" +
                "description='" + description + '\'' +
                ", problem='" + problem + '\'' +
                ", solution='" + solution + '\'' +
                ", monetization='" + monetization + '\'' +
                ", lesson='" + lesson + '\'' +
                ", company=" + company +
                '}';
    }

    protected Venture(Parcel in) {
        description = in.readString();
        problem = in.readString();
        solution = in.readString();
        monetization = in.readString();
        lesson = in.readString();
        company = (Company) in.readValue(Company.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(problem);
        dest.writeString(solution);
        dest.writeString(monetization);
        dest.writeString(lesson);
        dest.writeValue(company);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Venture> CREATOR = new Parcelable.Creator<Venture>() {
        @Override
        public Venture createFromParcel(Parcel in) {
            return new Venture(in);
        }

        @Override
        public Venture[] newArray(int size) {
            return new Venture[size];
        }
    };
}