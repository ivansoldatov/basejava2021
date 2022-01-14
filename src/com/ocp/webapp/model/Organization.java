package com.ocp.webapp.model;

import com.ocp.webapp.util.LocalDateAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.ocp.webapp.util.DateUtil.NOW;
import static com.ocp.webapp.util.DateUtil.of;


@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    public static final long serialVersionIID = 1L;
    private Link homePage;
    private List<Experience> experience;

    public Organization() {
    }

    public Organization(String name, String url, Experience... experiences) {
        this(new Link(name, url), Arrays.asList(experiences));
    }

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

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Experience implements Serializable {
        public static final long serialVersionIID = 1L;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startDate;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate endDate;
        private String title;
        private String description;

        public Experience() {
        }

        public Experience(int startYear, Month startMonth, String title) {
            this(of(startYear, startMonth), NOW, title, null);
        }

        public Experience(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), NOW, title, description);
        }

        public Experience(int startYear, Month startMonth, int endYear, Month endMonth, String title) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, "");
        }

        public Experience(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Experience(@NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotNull String title, @Nullable String description) {
            Objects.requireNonNull(startDate, "startDate must be not null");
            Objects.requireNonNull(endDate, "endDate must be not null");
            Objects.requireNonNull(title, "title must be not null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Experience that = (Experience) o;

            if (!startDate.equals(that.startDate)) return false;
            if (!endDate.equals(that.endDate)) return false;
            if (!title.equals(that.title)) return false;
            return description != null ? description.equals(that.description) : that.description == null;
        }

        @Override
        public int hashCode() {
            int result = startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy");
            return dtf.format(startDate) + " - " + dtf.format(endDate) + "  " + title + '\n' + description + '\n';
        }
    }
}


