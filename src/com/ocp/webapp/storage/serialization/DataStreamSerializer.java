package com.ocp.webapp.storage.serialization;

import com.ocp.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(OutputStream os, Resume resume) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                SectionType sectionType = entry.getKey();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        TextSection ts = (TextSection) entry.getValue();
                        dos.writeUTF(ts.getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        ListSection ls = (ListSection) entry.getValue();
                        dos.writeInt(ls.getItems().size());
                        for (String item : ls.getItems()) {
                            dos.writeUTF(item);
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        OrganizationSection orgSection = (OrganizationSection) entry.getValue();
                        dos.writeInt(orgSection.getOrganizations().size());
                        for (Organization organization : orgSection.getOrganizations()) {
                            dos.writeUTF(organization.getHomePage().getName());
                            dos.writeUTF(organization.getHomePage().getUrl());
                            dos.writeInt(organization.getExperience().size());
                            for (Organization.Experience exp : organization.getExperience()) {
                                dos.writeUTF(exp.getStartDate().toString());
                                dos.writeUTF(exp.getEndDate().toString());
                                dos.writeUTF(exp.getTitle());
                                dos.writeUTF(exp.getDescription());
                            }
                        }
                        break;
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            int numberContacts = dis.readInt();
            for (int i = 0; i < numberContacts; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            int numberSections = dis.readInt();
            for (int i = 0; i < numberSections; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.addSection(sectionType, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        int numberListItems = dis.readInt();
                        List list = new ArrayList(numberListItems);
                        for (int n = 0; n < numberListItems; n++) {
                            list.add(dis.readUTF());
                        }
                        resume.addSection(sectionType, new ListSection(list));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        int numberOrganizations = dis.readInt();
                        List listOrganizations = new ArrayList(numberOrganizations);
                        for (int p = 0; p < numberOrganizations; p++) {
                            Link link = new Link(dis.readUTF(), dis.readUTF());
                            int numberExperience = dis.readInt();
                            List listExperience = new ArrayList(numberExperience);
                            for (int e = 0; e < numberExperience; e++) {
                                Organization.Experience experience = new Organization.Experience(LocalDate.parse(dis.readUTF()), LocalDate.parse(dis.readUTF()), dis.readUTF(), dis.readUTF());
                                listExperience.add(experience);
                            }
                            listOrganizations.add(new Organization(link, listExperience));
                        }
                        resume.addSection(sectionType, new OrganizationSection(listOrganizations));
                        break;
                }

            }
            return resume;

        }
    }
}
