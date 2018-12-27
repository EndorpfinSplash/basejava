package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializerImpl implements SerializationStrategy{
    XmlParser xmlParser;

    public XmlStreamSerializerImpl() {
        xmlParser = new XmlParser(
                Resume.class,
                Link.class,
                SectionExperience.class,
                SectionListOfString.class,
                SectionText.class,
                ExperienceInCompany.Position.class,
                AbstractSection.class
        );
    }

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os,StandardCharsets.UTF_8)){
            xmlParser.marshall(resume, w);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)){
            return xmlParser.unmarshall(r);
        }
    }
}
