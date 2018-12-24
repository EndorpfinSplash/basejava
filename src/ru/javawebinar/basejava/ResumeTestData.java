package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.time.Month;
import java.util.*;

import static ru.javawebinar.basejava.util.DateUtil.NOW;

public class ResumeTestData {
    public static void main(String[] args) {


        System.out.println(createResume("111", "Григорий Кислин"));
    }

    public static Resume createResume(String uuid, String name) {
        Resume resume = new Resume(uuid, name);

        Map<ContactType, String> contact_map = new EnumMap<>(ContactType.class);
        contact_map.put(ContactType.PHONE, "+7(921) 855-0482");
        contact_map.put(ContactType.SKYPE, "grigory.kislin");
        contact_map.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contact_map.put(ContactType.LINKEDIN, "https://www.LINKEDIN.com/in/gkislin");
        contact_map.put(ContactType.GITHUB, "https://GITHUB.com/gkislin");
        contact_map.put(ContactType.STACKOWERFLOW, "https://stackoverflow.com/users/548473");
        contact_map.put(ContactType.HOMPAGE, "http://gkislin.ru/");

        resume.setContacts(contact_map);

        Map<SectionType, AbstractSection> section_map = new EnumMap<>(SectionType.class);


        section_map.put(SectionType.OBJECTIVE, new SectionWithText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        section_map.put(SectionType.PERSONAL, new SectionWithText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> achievementList = new LinkedList<String>() {{
            add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
            add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
            add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера");
            add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
            add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
            add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        }};

        section_map.put(SectionType.ACHIEVEMENT, new SectionWithListOfString(achievementList));

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

        section_map.put(SectionType.QUALIFICATIONS, new SectionWithListOfString(qualificationList));

        List<ExperienceInCompany> experienceInCompanies = new ArrayList<>();

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Java Online Projects", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2013, Month.OCTOBER),
                                                NOW,
                                                "Автор проекта.",
                                                "Создание, организация и проведение Java онлайн проектов и стажировок."
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Wrike", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2013, Month.OCTOBER),
                                                DateUtil.of(),
                                                "Автор проекта.",
                                                "Создание, организация и проведение Java онлайн проектов и стажировок."
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("RIT Center", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2012, Month.APRIL),
                                                DateUtil.of(2014, Month.OCTOBER),
                                                "Java архитектор",
                                                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Luxoft (Deutsche Bank)", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2010, Month.DECEMBER),
                                                DateUtil.of(2012, Month.APRIL),
                                                "Ведущий программист",
                                                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Yota", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2008, Month.JUNE),
                                                DateUtil.of(2010, Month.DECEMBER),
                                                "Ведущий специалист",
                                                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Enkata", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2007, Month.MARCH),
                                                DateUtil.of(2008, Month.JUNE),
                                                "Разработчик ПО",
                                                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Siemens AG", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2005, Month.JANUARY),
                                                DateUtil.of(2007, Month.FEBRUARY),
                                                "Разработчик ПО",
                                                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)./ Jython, Django, ExtJS)"
                                        )
                                )
                        )
                )
        );

        experienceInCompanies.add(
                new ExperienceInCompany(
                        new Link("Alcatel", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(1997, Month.SEPTEMBER),
                                                DateUtil.of(2005, Month.JANUARY),
                                                "Инженер по аппаратному и программному тестированию",
                                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                                        )
                                )
                        )
                )
        );

        SectionExperience sectionExperience = new SectionExperience(experienceInCompanies);

        section_map.put(SectionType.EXPERIENCE, sectionExperience);


        List<ExperienceInCompany> educationInCompanies = new ArrayList<>();

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Coursera", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2013, Month.MARCH),
                                                DateUtil.of(2013, Month.MAY),
                                                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                                                ""
                                        )
                                )
                        )
                )
        );

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Luxoft", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2011, Month.MARCH),
                                                DateUtil.of(2011, Month.APRIL),
                                                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                                                ""
                                        )
                                )
                        )
                )
        );

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Siemens AG", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(2005, Month.JANUARY),
                                                DateUtil.of(2005, Month.APRIL),
                                                "3 месяца обучения мобильным IN сетям (Берлин)",
                                                ""
                                        )
                                )
                        )
                )
        );

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Alcatel", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(1997, Month.SEPTEMBER),
                                                DateUtil.of(1998, Month.MARCH),
                                                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                                ""
                                        )
                                )
                        )
                )
        );

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(1993, Month.SEPTEMBER),
                                                DateUtil.of(1996, Month.JUNE),
                                                "Аспирантура (программист С, С++)",
                                                ""
                                        ),
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(1987, Month.SEPTEMBER),
                                                DateUtil.of(1993, Month.JUNE),
                                                "Инженер (программист Fortran, C)",
                                                ""
                                        )
                                )
                        )
                )
        );

        educationInCompanies.add(
                new ExperienceInCompany(
                        new Link("Заочная физико-техническая школа при МФТИ", null),
                        new ArrayList<>(
                                Arrays.asList(
                                        new ExperienceInCompany.Position(
                                                DateUtil.of(1984, Month.SEPTEMBER),
                                                DateUtil.of(1987, Month.JUNE),
                                                "Закончил с отличием",
                                                ""
                                        )
                                )
                        )
                )
        );

        section_map.put(SectionType.EDUCATION, new SectionExperience(educationInCompanies));
        resume.setSections(section_map);
        return resume;
    }
}
