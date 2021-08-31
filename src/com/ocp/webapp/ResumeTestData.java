package com.ocp.webapp;

import com.ocp.webapp.model.*;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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

    private static String achievementItem_1 ="С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."


    public static EnumMap<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);
    public static EnumMap<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    private static AbstractSection objectiveSection = new TextSection(objectiveText);
    private static AbstractSection personalSection = new TextSection(personalText);


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
