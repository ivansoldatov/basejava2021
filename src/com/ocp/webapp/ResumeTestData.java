package com.ocp.webapp;

import com.ocp.webapp.model.*;
import com.ocp.webapp.util.DateUtil;

import java.time.Month;
import java.util.*;

public class ResumeTestData {

    public static Resume resume = new Resume("Григорий Кислин");
    public static EnumMap<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);
    public static EnumMap<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    private static String phone = "+7(921) 855-0482";
    private static String mail = "gkislin@yandex.ru";
    private static String github = "https://github.com/gkislin";
    private static String homepage = "http://gkislin.ru/";
    private static String linkedin = "https://www.linkedin.com/in/gkislin";
    private static String skype = "grigory.kislin";

    private static String objectiveText = "Название позиции на которую претендую";
    private static String personalText = "Описание личных качеств";

    private static String achievementItem_1 = "Достижения номер 1";
    private static String achievementItem_2 = "Достижения номер 2";
    private static String achievementItem_3 = "Достижения номер 3";
    private static List<String> achievementList = Arrays.asList(achievementItem_1, achievementItem_2, achievementItem_3);

    private static String qualificationItm_1 = "Описание квалификации 1";
    private static String qualificationItm_2 = "Описание квалификации 2";
    private static String qualificationItm_3 = "Описание квалификации 3";
    private static List<String> qualificationList = Arrays.asList(qualificationItm_1, qualificationItm_2, qualificationItm_3);

    private static Organization.Link Link_Organization_1 = new Organization.Link("Компания-1", "Url Компании-1");
    private static Organization.Link Link_Organization_2 = new Organization.Link("Компания-2", "Url Компании-2");
    private static Organization.Link Link_Organization_3 = new Organization.Link("Компания-3");

    private static Experience experience_1 = new Experience(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2005, Month.JUNE), "Должность в Компании-1", "Опыт в Компании-1");
    private static Experience experience_2 = new Experience(DateUtil.of(2005, Month.JANUARY), DateUtil.of(2007, Month.FEBRUARY), "Должность в Компании-2", "Опыт в Компании-3");
    private static Experience experience_3 = new Experience(DateUtil.of(2007, Month.MARCH), DateUtil.of(2008, Month.JUNE), "Должность в Компании-3", "Опыт в Компании-3");

    private static Organization organization_1 = new Organization(Link_Organization_1, Arrays.asList(experience_1));
    private static Organization organization_2 = new Organization(Link_Organization_2, Arrays.asList(experience_2));
    private static Organization organization_3 = new Organization(Link_Organization_3, Arrays.asList(experience_3));
    private static List<Organization> organizationsList = Arrays.asList(organization_1, organization_2, organization_3);

    private static Organization.Link Link_Education_1 = new Organization.Link("Институт-1", "Url Институт-1");
    private static Organization.Link Link_Education_2 = new Organization.Link("Институт-2");
    private static Organization.Link Link_Education_3 = new Organization.Link("Интститут-3", "Url Институт-3");

    private static Experience education_1 = new Experience(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2000, Month.JUNE), "Образование-1 в Институте-1");
    private static Experience education_2 = new Experience(DateUtil.of(2000, Month.JANUARY), DateUtil.of(2005, Month.FEBRUARY), "Образование-2 в Институте-2");
    private static Experience education_3 = new Experience(DateUtil.of(2005, Month.MARCH), DateUtil.of(2008, Month.JUNE), "Образование-3 в Институте-3");
    private static Experience education_4 = new Experience(DateUtil.of(2009, Month.MARCH), DateUtil.of(2010, Month.JUNE), "Образование-4 в Институте-3");

    private static Organization University_1 = new Organization(Link_Education_1, Arrays.asList(education_1));
    private static Organization University_2 = new Organization(Link_Education_2, Arrays.asList(education_2));
    private static Organization University_3 = new Organization(Link_Education_3, Arrays.asList(education_3, education_4));
    private static List<Organization> educationList = Arrays.asList(University_1, University_2, University_3);

    private static AbstractSection objectiveSection = new TextSection(objectiveText);
    private static AbstractSection personalSection = new TextSection(personalText);
    private static AbstractSection achievementSection = new ListSection(achievementList);
    private static AbstractSection qualificationSection = new ListSection(qualificationList);
    private static AbstractSection experienceSection = new OrganizationSection(organizationsList);
    private static AbstractSection educationSection = new OrganizationSection(educationList);

    public static void main(String[] args) {
        printResume(getFillResume("000001", "григорий Кослин"));
    }

    private static void fillResume(Resume resume) {
        contacts.put(ContactType.PHONE, phone);
        contacts.put(ContactType.MAIL, mail);
        contacts.put(ContactType.GITHUB, github);
        contacts.put(ContactType.HOMEPAGE, homepage);
        contacts.put(ContactType.LINKEDIN, linkedin);
        contacts.put(ContactType.SKYPE, skype);
        sections.put(SectionType.OBJECTIVE, objectiveSection);
        sections.put(SectionType.PERSONAL, personalSection);
        sections.put(SectionType.ACHIEVEMENT, achievementSection);
        sections.put(SectionType.QUALIFICATIONS, qualificationSection);
        sections.put(SectionType.EXPERIENCE, experienceSection);
        sections.put(SectionType.EDUCATION, educationSection);
        resume.setContacts(contacts);
        resume.setSections(sections);

    }

    public static Resume getFillResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        fillResume(resume);
        return resume;
    }

    private static void printResume(Resume resume) {
        System.out.println(resume.getUuid());
        System.out.println(resume.getFullName());
        for (Map.Entry<ContactType, String> entry : resume.getContacts().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
            SectionType sectionType = entry.getKey();
            System.out.println(sectionType + ": ");
            switch (sectionType) {
                case OBJECTIVE:
                case PERSONAL:
                    TextSection textSection = (TextSection) entry.getValue();
                    System.out.println(textSection.getContent());
                    System.out.println();
                    break;
                case ACHIEVEMENT:
                case QUALIFICATIONS:
                    ListSection listSection = (ListSection) entry.getValue();
                    for (String s : listSection.getItems()) {
                        System.out.println(s);
                    }
                    System.out.println();
                    break;
                case EXPERIENCE:
                case EDUCATION:
                    OrganizationSection organizationSection = (OrganizationSection) entry.getValue();
                    for (Organization org : organizationSection.getOrganizations()) {
                        System.out.println(org.getHomePage().getName() + ": " + org.getHomePage().getUrl());
                        for (Experience exp : org.getExperience()) {
                            int startMonth = exp.getStartDate().getMonthValue();
                            int startYear = exp.getStartDate().getYear();
                            int endMonth = exp.getStartDate().getMonthValue();
                            int endYear = exp.getStartDate().getYear();
                            System.out.printf("%d.%d-%d.%d   %s\n", startMonth, startYear, endMonth, endYear, exp.getTitle());
                            System.out.println(exp.getDescription());
                        }
                    }
                    System.out.println();
                    break;
            }
        }

    }

}
