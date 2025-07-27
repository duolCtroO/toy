package oort.cloud.document.importer;

import oort.cloud.document.domain.Document;
import oort.cloud.document.domain.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReportImporter implements Importer{
    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);
        textFile.addSuffix(NAME_PREFIX, Attributes.PATIENT.getValue());
        textFile.addLine(2, line -> false, Attributes.BODY.getValue());

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attributes.TYPE.getValue(), "REPORT");
        return new Document(attributes);
    }
}
