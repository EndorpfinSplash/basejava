package ru.javawebinar.basejava.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;
    private String fullName;
    private Map<ContactType, String> Contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, AbstractSection> Sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(String uuid, String fullName, Map<ContactType, String> contacts, Map<SectionType, AbstractSection> sections) {
        this.uuid = uuid;
        this.fullName = fullName;
        Contacts = contacts;
        Sections = sections;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Map<SectionType, AbstractSection> getSections() {
        return Sections;
    }

    public void setSections(Map<SectionType, AbstractSection> sections) {
        Sections = sections;
    }

    public Map<ContactType, String> getContacts() {
        return Contacts;
    }

    public void setContacts(Map<ContactType, String> contacts) {
        Contacts = contacts;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String convertString() {
        String cont = "";
        String sect = "";
        for (Map.Entry<ContactType, String> entry : Contacts.entrySet()) {
            cont = cont + entry.getKey().getType() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<SectionType, AbstractSection> entry : Sections.entrySet()) {
            sect = sect + entry.getKey().getTitle() + "\n" + entry.getValue() +
                    "\n --------------------------------------------------------------------------------------------------\n";
        }

        return "Resume{" +
                "\n" +
                "uuid='" + uuid + '\'' +
                "\n" +
                fullName +
                "\n" +
                cont +
                "\n" +
                sect +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, fullName);
    }
}
