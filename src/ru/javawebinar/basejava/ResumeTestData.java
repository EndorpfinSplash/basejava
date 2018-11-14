package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.util.LinkedList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("111", "G.Kislin");
        resume.getContacts().put(ContactType.phoneHome, "telefon");
        resume.getContacts().put(ContactType.skype, "grigory.kislin");

        resume.getSections().put(SectionType.OBJECTIVE,new SectionWithText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.getSections().put(SectionType.PERSONAL,new SectionWithText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String > achievmList = new LinkedList<String>(){{
            add("С 2013 года: разработка проектов");
            add("Pеализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike");
            add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM.");
        }};

        resume.getSections().put(SectionType.ACHIEVEMENT,new StringSections( achievmList));

        List<Education> educationList = new LinkedList<>();
       // educationList.add(new Education("Java Online Projects",new Education.new SubPeriod()));


    }
}
