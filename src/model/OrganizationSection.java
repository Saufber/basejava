package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private static final long serialVersionUID =1L;

    private final List<Organization> organization;

    public OrganizationSection(Organization... organization){
        this (Arrays.asList(organization));
    }

    public OrganizationSection(List<Organization> organization) {
        Objects.requireNonNull(organization, "organization must not be null");
        this.organization = organization;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return organization.hashCode();
    }
}
