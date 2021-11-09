package com.ocp.webapp.storage.serialization;

import com.ocp.webapp.model.*;
import com.ocp.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements StreamSerializer {

    private final XmlParser xmlParser;

    public XmlStreamSerializer() {
        xmlParser = new XmlParser(Resume.class, Organization.class, Link.class, OrganizationSection.class,
                TextSection.class, ListSection.class, Organization.Experience.class);
    }

    @Override
    public void doWrite(OutputStream os, Resume resume) throws IOException {
        try (Writer wr = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(resume, wr);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (Reader rd = new InputStreamReader(is)) {
            return xmlParser.unmarshall(rd);
        }
    }
}
