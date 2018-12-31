package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DataStreamStrategyImpl implements SerializationStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            /// Contacts write
            dos.writeInt(resume.getContacts().size());
            for (Map.Entry<ContactType, String> entry : resume.getContacts().entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            /// Sections text write
            dos.writeInt(resume.getSections().size());
            for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
                dos.writeUTF(entry.getKey().name());
                String sectType = entry.getValue().getClass().getCanonicalName();
                dos.writeUTF(sectType);
                switch (sectType) {
                    case "ru.javawebinar.basejava.model.SectionText":
                        dos.writeUTF(entry.getValue().toString());
                        break;

                    case "ru.javawebinar.basejava.model.SectionListOfString":
                        List<String> sectionList = ((SectionListOfString) entry.getValue()).getSectionList();
                        dos.writeInt(sectionList.size());

                        sectionList.forEach(s -> {
                            try {
                                dos.writeUTF(s);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;

                    case "ru.javawebinar.basejava.model.SectionExperience":
                        SectionExperience sectionExperience = ((SectionExperience) entry.getValue());
                        List<ExperienceInCompany> experienceInCompanies = sectionExperience.getExperienceInCompanies();
                        int experienceCount = experienceInCompanies.size();
                        dos.writeInt(experienceCount);

                        experienceInCompanies.forEach(experienceInCompany -> {
                            try {
                                dos.writeUTF(experienceInCompany.getCompany().getName());
                                dos.writeUTF(experienceInCompany.getCompany().getUrl());
                                List<ExperienceInCompany.Position> positionList = experienceInCompany.getPositionList();
                                dos.writeInt(positionList.size());
                                positionList.forEach(position -> {
                                    try {
                                        writeLocalDate(dos,position.getStartDate());
                                        writeLocalDate(dos,position.getEndDate());
                                        dos.writeUTF(position.getTitle());
                                        dos.writeUTF(position.getDescription());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                }
            }
        }
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate stDate) throws IOException {
        dos.writeInt(stDate.getYear());
        dos.writeInt(stDate.getMonth().getValue());
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            /// Contacts reading
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            /// Sections reading
            int sectionsCount = dis.readInt();
            Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
            for (int i = 0; i < sectionsCount; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                String secType = dis.readUTF();

                switch (secType) {
                    case "ru.javawebinar.basejava.model.SectionText":
                        SectionText sectionText = new SectionText(dis.readUTF());
                        sections.put(sectionType,sectionText);
                        break;
                    case "ru.javawebinar.basejava.model.SectionListOfString":
                        int listOfStringCount = dis.readInt();
                        ArrayList<String> sectionList = new ArrayList<>();

                        for (int j = 0; j < listOfStringCount; j++) {
                            sectionList.add(j, dis.readUTF());
                        }

                        sections.put(sectionType, new SectionListOfString(sectionList));
                        break;
                    case "ru.javawebinar.basejava.model.SectionExperience":
                        int experienceCount = dis.readInt();

                        List<ExperienceInCompany> experienceInCompanies = new ArrayList<>();
                        for (int j = 0; j < experienceCount; j++) {
                            String company = dis.readUTF();
                            String url = dis.readUTF();
                            Link link = new Link(company, url);
                            int positionCount = dis.readInt();
                            List<ExperienceInCompany.Position> positionList = new ArrayList<>();
                            for (int k = 0; k < positionCount; k++) {
                                LocalDate stDate  = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                LocalDate endDate = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                String title = dis.readUTF();
                                String description = dis.readUTF();
                                positionList.add(k, new ExperienceInCompany.Position(stDate,endDate,title,description));
                            }
                            experienceInCompanies.add(j, new ExperienceInCompany(link,positionList));
                        }
                        sections.put(sectionType, new SectionExperience(experienceInCompanies));
                        break;
                }
            }
            resume.setSections(sections);

            return resume;
        }

    }
}
