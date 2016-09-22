package com.yapd.alexander.yapd.core.model;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public class Company {
    private String name;
    private String description;
    private String location;
    private String logoUrl;
    private String websiteUrl;
    private List<String> featuredImageUrls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<String> getFeaturedImageUrls() {
        return featuredImageUrls;
    }

    public void setFeaturedImageUrls(List<String> featuredImageUrls) {
        this.featuredImageUrls = featuredImageUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null)
            return false;
        if (location != null ? !location.equals(company.location) : company.location != null)
            return false;
        if (logoUrl != null ? !logoUrl.equals(company.logoUrl) : company.logoUrl != null)
            return false;
        if (websiteUrl != null ? !websiteUrl.equals(company.websiteUrl) : company.websiteUrl != null)
            return false;
        return featuredImageUrls != null ? featuredImageUrls.equals(company.featuredImageUrls) : company.featuredImageUrls == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        result = 31 * result + (featuredImageUrls != null ? featuredImageUrls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", featuredImageUrls=" + featuredImageUrls +
                '}';
    }
}
