package oort.cloud.document.importer;

import oort.cloud.document.domain.Document;
import oort.cloud.document.domain.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class InvoiceImporter implements Importer{
    private static final String NAME_PREFIX = "Dear: ";
    private static final String AMOUNT_PREFIX = "Amount: ";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);

        textFile.addSuffix(NAME_PREFIX, Attributes.PATIENT.getValue());
        textFile.addSuffix(AMOUNT_PREFIX, Attributes.AMOUNT.getValue());

        Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attributes.TYPE.getValue(), "INVOICE");

        return new Document(attributes);
    }
}
