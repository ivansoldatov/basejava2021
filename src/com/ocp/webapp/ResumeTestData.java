package com.ocp.webapp;

import com.ocp.webapp.model.*;
import com.ocp.webapp.util.DateUtil;

import java.time.Month;
import java.util.*;

public class ResumeTestData {

    public static Resume resume = new Resume("Григорий Кислин");

    private static String phone = "+7(921) 855-0482";
    private static String mail = "gkislin@yandex.ru";
    private static String github = "https://github.com/gkislin";
    private static String homepage = "http://gkislin.ru/";
    private static String linkedin = "https://www.linkedin.com/in/gkislin";
    private static String skype = "grigory.kislin";

    private static String objectiveText = "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям";
    private static String personalText = "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.";

    private static String achievementItem_1 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.";
    private static String achievementItem_2 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
    private static String achievementItem_3 = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
    private static List<String> achievementList = Arrays.asList(achievementItem_1, achievementItem_2, achievementItem_3);

    private static String qualificationItm_1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
    private static String qualificationItm_2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
    private static String qualificationItm_3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle";
    private static List<String> qualificationList = Arrays.asList(qualificationItm_1, qualificationItm_2, qualificationItm_3);

    private static Organization.Link Link_Organization_1 = new Organization.Link("Компания-1", "Url link Компании-1");
    private static Organization.Link Link_Organization_2 = new Organization.Link("Компания-2", "Url link Компании-2");
    private static Organization.Link Link_Organization_3 = new Organization.Link("Компания-3");

    static Experience experience_1 = new Experience(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2005, Month.JUNE), "Должность в Компании-1", "Опыт в Компании-1");
    static Experience experience_2 = new Experience(DateUtil.of(2005, Month.JANUARY), DateUtil.of(2007, Month.FEBRUARY), "Должность в Компании-2", "Опыт в Компании-3");
    static Experience experience_3 = new Experience(DateUtil.of(2007, Month.MARCH), DateUtil.of(2008, Month.JUNE), "Должность в Компании-3", "Опыт в Компании-3");

    private static Organization organization_1 = new Organization(Link_Organization_1, Arrays.asList(experience_1));
    private static Organization organization_2 = new Organization(Link_Organization_2, Arrays.asList(experience_2));
    private static Organization organization_3 = new Organization(Link_Organization_3, Arrays.asList(experience_3));
    private static List<Organization> organizationsList = Arrays.asList(organization_1, organization_2, organization_3);
    //-----------------------------
    private static Organization.Link Link_Education_1 = new Organization.Link("Институт-1", "Url link Институт-1");
    private static Organization.Link Link_Education_2 = new Organization.Link("Институт-2");
    private static Organization.Link Link_Education_3 = new Organization.Link("Интститут-3", "Url link Институт-3");

    private static Experience education_1 = new Experience(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2000, Month.JUNE), "Образование-1 в Институте-1");
    private static Experience education_2 = new Experience(DateUtil.of(2000, Month.JANUARY), DateUtil.of(2005, Month.FEBRUARY), "Образование-2 в Институте-2");
    private static Experience education_3 = new Experience(DateUtil.of(2005, Month.MARCH), DateUtil.of(2008, Month.JUNE), "Образование-3 в Институте-3");
    private static Experience education_4 = new Experience(DateUtil.of(2009, Month.MARCH), DateUtil.of(2010, Month.JUNE), "Образование-4 в Институте-3");

    private static Organization University_1 = new Organization(Link_Organization_1, Arrays.asList(education_1));
    private static Organization University_2 = new Organization(Link_Organization_2, Arrays.asList(education_2));
    private static Organization University_3 = new Organization(Link_Organization_3, Arrays.asList(education_3, education_4));
    private static List<Organization> educationList = Arrays.asList(University_1, University_2, University_3);


    public static EnumMap<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);
    public static EnumMap<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);


    private static AbstractSection objectiveSection = new TextSection(objectiveText);
    private static AbstractSection personalSection = new TextSection(personalText);
    private static AbstractSection achievementSection = new ListSection(achievementList);
    private static AbstractSection qualificationSection = new ListSection(qualificationList);
    private static AbstractSection organizationSection = new OrganizationSection(organizationsList);
    private static AbstractSection educationSection = new OrganizationSection(educationList);


    public static void main(String[] args) {
        contacts.put(ContactType.PHONE, phone);
        contacts.put(ContactType.MAIL, mail);
        contacts.put(ContactType.GITHUB, github);
        contacts.put(ContactType.HOMEPAGE, homepage);
        contacts.put(ContactType.LINKEDIN, linkedin);
        contacts.put(ContactType.SKYPE, skype);
        resume.setContacts(contacts);


    }

}
