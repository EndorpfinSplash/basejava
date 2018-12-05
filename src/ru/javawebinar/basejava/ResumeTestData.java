package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.time.Month;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {


        System.out.println(createResume());
    }

    public static Resume createResume() {
        Resume resume = new Resume("111", "Григорий Кислин");

        resume.getContacts().put(ContactType.PHONE, "+7(921) 855-0482");
        resume.getContacts().put(ContactType.SKYPE, "grigory.kislin");
        resume.getContacts().put(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.getContacts().put(ContactType.LINKEDIN, "https://www.LINKEDIN.com/in/gkislin");
        resume.getContacts().put(ContactType.GITHUB, "https://GITHUB.com/gkislin");
        resume.getContacts().put(ContactType.STACKOWERFLOW, "https://stackoverflow.com/users/548473");
        resume.getContacts().put(ContactType.HOMPAGE, "http://gkislin.ru/");

        resume.getSections().put(SectionType.OBJECTIVE, new SectionWithText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.getSections().put(SectionType.PERSONAL, new SectionWithText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> achievementList = new LinkedList<String>() {{
            add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
            add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
            add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера");
            add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
            add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
            add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        }};

        resume.getSections().put(SectionType.ACHIEVEMENT, new SectionWithListOfString(achievementList));

        List<String> qualificationList = new LinkedList<String>() {{
            add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
            add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
            add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
            add("MySQL, SQLite, MS SQL, HSQLDB");
            add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
            add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
            add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
            add("Python: Django.");
            add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
            add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
            add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
            add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
            add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
            add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов");
            add("проектрирования, архитектурных шаблонов, UML, функционального программирования");
            add("Родной русский, английский \"upper intermediate\"");
        }};

        resume.getSections().put(SectionType.QUALIFICATIONS, new SectionWithListOfString(qualificationList));

        List<ExperienceInCompany> experienceInCompanies = new ArrayList<>();

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Java Online Projects", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new Experience(
                                                DateUtil.of(2013, Month.OCTOBER),
                                                DateUtil.of(),
                                                "Автор проекта.",
                                                "Создание, организация и проведение Java онлайн проектов и стажировок."
                                        )
                                )
                        )
                )
        );

        ExperienceSection experienceSection = new ExperienceSection(experienceInCompanies);

        List<Experience> experienceList = new LinkedList<>();

        experienceList.add(


                new Experience("Java Online Projects", null,
                        DateUtil.of(2013, Month.OCTOBER),
                        DateUtil.of(),
                        "Автор проекта.",
                        "Создание, организация и проведение Java онлайн проектов и стажировок."
                )
        );

        experienceList.add(
                new Experience("Wrike", null,
                        DateUtil.of(2014, Month.OCTOBER),
                        DateUtil.of(2016, Month.JANUARY),
                        "Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                )
        );

        experienceList.add(
                new Experience("RIT Center", null,
                        DateUtil.of(2012, Month.APRIL),
                        DateUtil.of(2014, Month.OCTOBER),
                        "Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                )
        );

        experienceList.add(
                new Experience("Luxoft (Deutsche Bank)", null,
                        DateUtil.of(2010, Month.DECEMBER),
                        DateUtil.of(2012, Month.APRIL),
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                )
        );

        experienceList.add(
                new Experience("Yota", null,
                        DateUtil.of(2008, Month.JUNE),
                        DateUtil.of(2010, Month.DECEMBER),
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                )
        );

        experienceList.add(
                new Experience("Enkata", null,
                        DateUtil.of(2007, Month.MARCH),
                        DateUtil.of(2008, Month.JUNE),
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                )
        );

        experienceList.add(
                new Experience("Siemens AG", null,
                        DateUtil.of(2005, Month.JANUARY),
                        DateUtil.of(2007, Month.FEBRUARY),
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)./ Jython, Django, ExtJS)"
                )
        );

        experienceList.add(
                new Experience("Alcatel", null,
                        DateUtil.of(1997, Month.SEPTEMBER),
                        DateUtil.of(2005, Month.JANUARY),
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                )
        );

        Map<Link, List<Experience>> experienceMap = new HashMap<>();

        for (Experience experience : experienceList) {

            List<Experience> experiencList = experienceMap.getOrDefault(experience.getCompany(), new ArrayList<>());
            experiencList.add(experience);

            experienceMap.put(
                    experience.getCompany(),
                    experiencList
            );
        }

        resume.getSections().put(SectionType.EXPERIENCE, new ExperienceSection(experienceMap));

        List<Experience> educationList = new LinkedList<>();

        educationList.add(
                new Experience("Coursera", null,
                        DateUtil.of(2013, Month.MARCH),
                        DateUtil.of(2013, Month.MAY),
                        "\"Functional Programming Principles in Scala\" by Martin Odersky",
                        ""
                )
        );

        educationList.add(
                new Experience("Luxoft", null,
                        DateUtil.of(2011, Month.MARCH),
                        DateUtil.of(2011, Month.APRIL),
                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                        ""
                )
        );

        educationList.add(
                new Experience("Siemens AG", null,
                        DateUtil.of(2005, Month.JANUARY),
                        DateUtil.of(2005, Month.APRIL),
                        "3 месяца обучения мобильным IN сетям (Берлин)",
                        ""
                )
        );

        educationList.add(
                new Experience("Alcatel", null,
                        DateUtil.of(1997, Month.SEPTEMBER),
                        DateUtil.of(1998, Month.MARCH),
                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                        ""
                )
        );

        educationList.add(
                new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", null,
                        DateUtil.of(1993, Month.SEPTEMBER),
                        DateUtil.of(1996, Month.JUNE),
                        "Аспирантура (программист С, С++)",
                        ""
                )
        );

        educationList.add(
                new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", null,
                        DateUtil.of(1987, Month.SEPTEMBER),
                        DateUtil.of(1993, Month.JUNE),
                        "Инженер (программист Fortran, C)",
                        ""
                )
        );

        educationList.add(
                new Experience("Заочная физико-техническая школа при МФТИ", null,
                        DateUtil.of(1984, Month.SEPTEMBER),
                        DateUtil.of(1987, Month.JUNE),
                        "Закончил с отличием",
                        ""
                )
        );

        Map<Link, List<Experience>> educationMap = new HashMap<>();

        for (Experience education : educationList) {

            List<Experience> eduList = educationMap.getOrDefault(education.getCompany(), new ArrayList<>());
            eduList.add(education);

            educationMap.put(
                    education.getCompany(),
                    eduList
            );
        }
        resume.getSections().put(SectionType.EDUCATION, new ExperienceSection(educationMap));
        return resume;
    }
}
