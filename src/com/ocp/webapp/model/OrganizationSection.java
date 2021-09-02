package com.ocp.webapp.model;

import java.util.List;

public class OrganizationSection extends AbstractSection {
    private List<Organization> listOrganization;

    public OrganizationSection(List<Organization> listOrganization) {
        this.listOrganization = listOrganization;
    }

    public List<Organization> getListOrganization() {
        return listOrganization;
    }

    public void setListOrganization(List<Organization> listOrganization) {
        this.listOrganization = listOrganization;
    }
}
