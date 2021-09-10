package com.ocp.webapp.model;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    public static final long serialVersionIID=1L;
    private final List<Organization> organizations;

    public OrganizationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(@NotNull List<Organization> organizations) {
        Objects.requireNonNull(organizations, "Organizations must be not null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Organization org : organizations) {
            sb.append(org.toString());
        }
        return sb.toString();
    }
}
