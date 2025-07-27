package oort.cloud.document;

import oort.cloud.document.domain.Document;

import java.io.IOException;
import java.util.Objects;

public class DocumentMain {
    public static void main(String[] args) throws IOException {
        DocumentManagementSystem dms = new DocumentManagementSystem();
        String path = Objects.requireNonNull(Document.class.getClassLoader().getResource("patient.invoice").getPath());
        dms.importFile(path);
    }
}
