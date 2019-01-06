package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class DataStreamStrategyImpl implements SerializationStrategy {

    <E> void writeWithException(Collection<E> collection, DataOutputStream dos, MyWriter<E> writer) throws IOException {
        int size = collection.size();
        dos.writeInt(size);
        for (E item : collection) {
            writer.write(item);
        }
    }

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

                        writeWithException(sectionList, dos, new MyWriter<String>() {
                            @Override
                            public void write(String s) throws IOException {
                                dos.writeUTF(s);
                            }
                        });
                        break;

                    case "ru.javawebinar.basejava.model.SectionExperience":
                        SectionExperience sectionExperience = ((SectionExperience) entry.getValue());
                        List<ExperienceInCompany> experienceInCompanies = sectionExperience.getExperienceInCompanies();

                        writeWithException(experienceInCompanies, dos, new MyWriter<ExperienceInCompany>() {
                            @Override
                            public void write(ExperienceInCompany experienceInCompany) throws IOException {
                                dos.writeUTF(experienceInCompany.getCompany().getName());
                                dos.writeUTF(experienceInCompany.getCompany().getUrl());

                                List<ExperienceInCompany.Position> positionList = experienceInCompany.getPositionList();
                                writeWithException(positionList, dos, new MyWriter<ExperienceInCompany.Position>() {
                                    @Override
                                    public void write(ExperienceInCompany.Position position) throws IOException {
                                        writeLocalDate(dos, position.getStartDate());
                                        writeLocalDate(dos, position.getEndDate());
                                        dos.writeUTF(position.getTitle());
                                        dos.writeUTF(position.getDescription());
                                    }
                                });
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


    <E> List<E> readList(DataInputStream dis, MyReader<E> myReader) throws IOException {
        int size = dis.readInt();
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(myReader.read());
        }
        return list;
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
                        sections.put(sectionType, sectionText);
                        break;

                    case "ru.javawebinar.basejava.model.SectionListOfString":
                        SectionListOfString sectionListOfString = new SectionListOfString(
                                readList(dis, new MyReader<String>() {
                                    @Override
                                    public String read() throws IOException {
                                        return dis.readUTF();
                                    }
                                })
                        );
                        sections.put(sectionType, sectionListOfString);
                        break;

                    case "ru.javawebinar.basejava.model.SectionExperience":

                        SectionExperience sectionExperience = new SectionExperience(
                                readList(dis, new MyReader<ExperienceInCompany>() {
                                    @Override
                                    public ExperienceInCompany read() throws IOException {
                                        return new ExperienceInCompany(
                                                new Link(dis.readUTF(), dis.readUTF()),
                                                DataStreamStrategyImpl.this.readList(dis, new MyReader<ExperienceInCompany.Position>() {
                                                    @Override
                                                    public ExperienceInCompany.Position read() throws IOException {
                                                        LocalDate stDate = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                                        LocalDate endDate = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                                        String title = dis.readUTF();
                                                        String description = dis.readUTF();
                                                        return new ExperienceInCompany.Position(stDate, endDate, title, description);
                                                    }
                                                })
                                        );
                                    }
                                })
                        );

                        sections.put(sectionType, sectionExperience);
                        break;
                }
            }
            resume.setSections(sections);

            return resume;
        }

    }
}
