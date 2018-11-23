package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.util.LinkedList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("111", "G.Kislin");
        resume.getContacts().put(ContactType.phoneHome, "telefon");
        resume.getContacts().put(ContactType.skype, "grigory.kislin");
        resume.getContacts().put(ContactType.email, "gkislin@yandex.ru");
        resume.getContacts().put(ContactType.linkedin, "https://www.linkedin.com/in/gkislin");
        resume.getContacts().put(ContactType.github, "https://github.com/gkislin");
        resume.getContacts().put(ContactType.stackowerflow, "https://stackoverflow.com/users/548473");
        resume.getContacts().put(ContactType.hompage, "http://gkislin.ru/");

        resume.getSections().put(SectionType.OBJECTIVE,new SectionWithText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.getSections().put(SectionType.PERSONAL,new SectionWithText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> achievmList = new LinkedList<String>() {{
            add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
            add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
            add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера");
            add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
            add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
            add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        }};

        resume.getSections().put(SectionType.ACHIEVEMENT,new StringSections( achievmList));

        List<Education> educationList = new LinkedList<>();
       // educationList.add(new Education("Java Online Projects",new Education.new SubPeriod()));


    }
}
