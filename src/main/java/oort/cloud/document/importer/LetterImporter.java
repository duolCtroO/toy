package oort.cloud.document.importer;

import oort.cloud.document.domain.Document;
import oort.cloud.document.domain.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LetterImporter implements Importer{
    private static final String NAME_PREFIX = "Dear ";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);

        textFile.addSuffix(NAME_PREFIX, Attributes.PATIENT.getValue());

        int lineNumber = textFile.addLine(2, String::isEmpty, Attributes.ADDRESS.getValue());
        textFile.addLine(lineNumber + 1, (line) -> line.startsWith("regard,"), Attributes.BODY.getValue());

        Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attributes.TYPE.getValue(), "LETTER");
        return new Document(attributes);
    }
}
