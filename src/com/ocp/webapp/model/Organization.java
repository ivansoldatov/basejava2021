package com.ocp.webapp.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Experience> experience;

    public Organization(@NotNull Link homePage, @NotNull List<Experience> experience) {
        Objects.requireNonNull(homePage, "Link must be not null");
        Objects.requireNonNull(experience, "Experience must be not null");
        this.homePage = homePage;
        this.experience = experience;
    }

    public Link getHomePage() {
        return homePage;
    }


    public List<Experience> getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + experience.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(homePage.toString());
        for (Experience exp : experience) {
            sb.append(exp.toString());
        }
        return sb.toString();
    }


    public static class Link {
        private final String name;
        private final String url;

        public Link(@NotNull String name, @Nullable String url) {
            Objects.requireNonNull(name, "name must not be null");
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Link link = (Link) o;

            if (!name.equals(link.name)) return false;
            return url != null ? url.equals(link.url) : link.url == null;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + (url != null ? url.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return name + "   " + url + '\n';
        }
    }


}


