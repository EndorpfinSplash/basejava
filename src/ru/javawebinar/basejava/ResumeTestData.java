package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.util.LinkedList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {

        Resume resume = new Resume("111", "Григорий Кислин");

        resume.getContacts().put(ContactType.phone, "+7(921) 855-0482");
        resume.getContacts().put(ContactType.skype, "grigory.kislin");
        resume.getContacts().put(ContactType.email, "gkislin@yandex.ru");
        resume.getContacts().put(ContactType.linkedin, "https://www.linkedin.com/in/gkislin");
        resume.getContacts().put(ContactType.github, "https://github.com/gkislin");
        resume.getContacts().put(ContactType.stackowerflow, "https://stackoverflow.com/users/548473");
        resume.getContacts().put(ContactType.hompage, "http://gkislin.ru/");

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

        List<Experience> experienceList = new LinkedList<>();

        experienceList.add(
                new Experience("Java Online Projects",null,
                        "10/2013",
                        "Сейчас",
                        "Автор проекта.",
                        "Создание, организация и проведение Java онлайн проектов и стажировок."
                )
        );

        experienceList.add(
                new Experience("Wrike",null,
                        "10/2014",
                        "01/2016",
                        "Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                )
        );

        experienceList.add(
                new Experience("RIT Center",null,
                        "04/2012",
                        "10/2014",
                        "Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                )
        );

        experienceList.add(
                new Experience("Luxoft (Deutsche Bank)",null,
                        "12/2010",
                        "04/2012",
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                )
        );

        experienceList.add(
                new Experience("Yota",null,
                        "06/2008",
                        "12/2010",
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                )
        );

        experienceList.add(
                new Experience("Enkata",null,
                        "03/2007",
                        "06/2008",
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                )
        );

        experienceList.add(
                new Experience("Siemens AG",null,
                        "01/2005",
                        "02/2007",
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)./ Jython, Django, ExtJS)"
                )
        );

        experienceList.add(
                new Experience("Alcatel",null,
                        "09/1997",
                        "01/2005",
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                )
        );

        resume.getSections().put(SectionType.EXPERIENCE, new ExperienceSections(experienceList));

        List<Experience> educationList = new LinkedList<>();

        educationList.add(
                new Experience("Coursera",null,
                        "03/2013",
                        "05/2013",
                        "\"Functional Programming Principles in Scala\" by Martin Odersky",
                        ""
                )
        );

        educationList.add(
                new Experience("Luxoft",null,
                        "03/2011",
                        "04/2011",
                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                        ""
                )
        );

        educationList.add(
                new Experience("Siemens AG",null,
                        "01/2005",
                        "04/2005",
                        "3 месяца обучения мобильным IN сетям (Берлин)",
                        ""
                )
        );

        educationList.add(
                new Experience("Alcatel",null,
                        "09/1997",
                        "03/1998",
                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                        ""
                )
        );

        educationList.add(
                new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",null,
                        "09/1993",
                        "07/1996",
                        "Аспирантура (программист С, С++)",
                        ""
                )
        );

        educationList.add(
                new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",null,
                        "09/1987",
                        "07/1993",
                        "Инженер (программист Fortran, C)",
                        ""
                )
        );

        educationList.add(
                new Experience("Заочная физико-техническая школа при МФТИ",null,
                        "09/1984",
                        "06/1987",
                        "Закончил с отличием",
                        ""
                )
        );

        resume.getSections().put(SectionType.EDUCATION, new ExperienceSections(educationList));

        System.out.println(resume.convertString());

    }
}
