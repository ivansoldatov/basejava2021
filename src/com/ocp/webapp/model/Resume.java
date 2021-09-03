package com.ocp.webapp.model;

import org.jetbrains.annotations.NotNull;

import java.rmi.server.UID;
import java.util.*;


public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private  Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private  Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Resume(@NotNull String fullName) {
        this(UUID.randomUUID().toString(), fullName);

    }

    public Resume(@NotNull String uuid, @NotNull String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public AbstractSection getSection(SectionType type) {
        return sections.get(type);
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public void setContacts(EnumMap<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }

    public void setSections(EnumMap<SectionType, AbstractSection> sections) {
        this.sections = sections;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + " - " + fullName;
    }


    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);

    }
}
