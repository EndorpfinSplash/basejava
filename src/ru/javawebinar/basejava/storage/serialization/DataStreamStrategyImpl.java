package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataStreamStrategyImpl implements SerializationStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            /// Contacts write

            writeWithException(resume.getContacts().entrySet(), dos, entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });


            writeWithException(resume.getSections().entrySet(), dos, entry -> {
                SectionType sectionType = entry.getKey();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(entry.getValue().toString());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeWithException(
                                ((SectionListOfString) entry.getValue()).getSectionList(),
                                dos, dos::writeUTF
                        );
                        break;
                    case EDUCATION:
                    case EXPERIENCE:
                        writeWithException(
                                ((SectionExperience) entry.getValue()).getExperienceInCompanies(),
                                dos,
                                experienceInCompany -> {
                                    dos.writeUTF(experienceInCompany.getCompany().getName());
                                    dos.writeUTF(experienceInCompany.getCompany().getUrl());

                                    writeWithException(experienceInCompany.getPositionList(), dos, position -> {
                                        writeLocalDate(dos, position.getStartDate());
                                        writeLocalDate(dos, position.getEndDate());
                                        dos.writeUTF(position.getTitle());
                                        dos.writeUTF(position.getDescription());
                                    });
                                }
                        );
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            /// Contacts reading

            readMap(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));


            /// Sections reading

            readMap(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.addSection(sectionType, new SectionText(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.addSection(sectionType, new SectionListOfString(
                                readList(dis, dis::readUTF)
                        ));
                        break;
                    case EDUCATION:
                    case EXPERIENCE:
                        resume.addSection(sectionType, new SectionExperience(
                                readList(dis, () -> new ExperienceInCompany(
                                        new Link(dis.readUTF(), dis.readUTF()),
                                        readList(dis, () -> {
                                            LocalDate stDate = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                            LocalDate endDate = DateUtil.of(dis.readInt(), Month.of(dis.readInt()));
                                            String title = dis.readUTF();
                                            String description = dis.readUTF();
                                            return new ExperienceInCompany.Position(stDate, endDate, title, description);
                                        })
                                ))
                        ));
                        break;
                }
            });

            return resume;
        }
    }

    private <E> void writeWithException(Collection<E> collection, DataOutputStream dos, MyWriter<E> writer) throws IOException {
        int size = collection.size();
        dos.writeInt(size);
        for (E item : collection) {
            writer.write(item);
        }
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate stDate) throws IOException {
        dos.writeInt(stDate.getYear());
        dos.writeInt(stDate.getMonth().getValue());
    }

    private <E> List<E> readList(DataInputStream dis, MyReader<E> myReader) throws IOException {
        int size = dis.readInt();
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(myReader.read());
        }
        return list;
    }


    private void readMap(DataInputStream dis, MyReaderForMap myReaderForMap) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            myReaderForMap.read();
        }
    }
}
