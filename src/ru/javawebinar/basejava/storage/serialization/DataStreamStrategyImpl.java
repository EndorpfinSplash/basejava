package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class DataStreamStrategyImpl implements SerializationStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            /// Contacts write

            writeWithExceptionForMap(resume.getContacts(), dos, entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });


            writeWithExceptionForMap(resume.getSections(), dos, entry -> {
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
            Map<ContactType, String> contacts = readMapContacts(dis, map -> map.put(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            resume.setContacts(contacts);


            /// Sections reading
            Map<SectionType, AbstractSection> sections =
                    readMapSections(dis, map -> {
                        SectionType sectionType = SectionType.valueOf(dis.readUTF());
                        switch (sectionType) {
                            case OBJECTIVE:
                            case PERSONAL:
                                map.put(sectionType, new SectionText(dis.readUTF()));
                                break;
                            case ACHIEVEMENT:
                            case QUALIFICATIONS:
                                map.put(sectionType, new SectionListOfString(
                                        readList(dis, dis::readUTF)
                                ));
                                break;
                            case EDUCATION:
                            case EXPERIENCE:
                                map.put(sectionType, new SectionExperience(
                                        readList(dis, () -> new ExperienceInCompany(
                                                new Link(dis.readUTF(), dis.readUTF()),
                                                DataStreamStrategyImpl.this.readList(dis, () -> {
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

            resume.setSections(sections);

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

    private <K, V> void writeWithExceptionForMap(Map<K, V> map, DataOutputStream dos, MyWriterForMap<K, V> myWriterForMap) throws IOException {
        dos.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            myWriterForMap.write(entry);
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

    private <K extends Enum<K>, V> Map<K, V> readMapContacts(DataInputStream dis, MyReaderForMap<K, V> myReaderForMap) throws IOException {
        int size = dis.readInt();
        Map<K, V> map = new EnumMap<>((Class<K>) ContactType.class);

        for (int i = 0; i < size; i++) {
            myReaderForMap.read(map);
        }
        return map;
    }

    private <K extends Enum<K>, V> Map<K, V> readMapSections(DataInputStream dis, MyReaderForMap<K, V> myReaderForMap) throws IOException {
        int size = dis.readInt();
        Map<K, V> map = new EnumMap<>((Class<K>) SectionType.class);

        for (int i = 0; i < size; i++) {
            myReaderForMap.read(map);
        }
        return map;
    }
}
