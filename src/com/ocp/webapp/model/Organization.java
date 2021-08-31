package com.ocp.webapp.model;

import java.util.List;

public class Organization {
    private Link homePage;
    private List<Experience> experience;

    public Organization(Link homePage, List<Experience> experience) {
        this.homePage = homePage;
        this.experience = experience;
    }

    public Link getHomePage() {
        return homePage;
    }

    public void setHomePage(Link homePage) {
        this.homePage = homePage;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    class Link {
        private String name;
        private String url;

        public Link(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}


