package oort.cloud.document;

import oort.cloud.document.domain.Document;
import oort.cloud.document.importer.*;

import javax.lang.model.type.UnknownTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> viewDocuments = Collections.unmodifiableList(documents);

    private final Map<String, Importer> extensionsToImporters = new HashMap<>();

    public DocumentManagementSystem(){
        extensionsToImporters.put("report", new ReportImporter());
        extensionsToImporters.put("letter", new LetterImporter());
        extensionsToImporters.put("jpg", new ImageImporter());
        extensionsToImporters.put("invoice", new InvoiceImporter());
    }

    public void importFile(String filePath) throws IOException {
        File file = new File(filePath);

        int separatorIndex = validateFile(file, filePath);

        String extension = filePath.substring(separatorIndex + 1);

        Importer importer = getImporter(extension);

        Document document = importer.importFile(file);

        documents.add(document);
    }

    public Importer getImporter(String extension){
        Importer importer = extensionsToImporters.get(extension);
        if(importer == null){
            throw new UnknownFileTypeException("Unknown file type : " + extension);
        }
        return importer;
    }

    private int validateFile(File file, String filePath) throws FileNotFoundException {
        if(!file.exists()){
            throw new FileNotFoundException("File not found : " + filePath);
        }

        int separatorIndex = filePath.lastIndexOf(".");

        if(separatorIndex == -1){
            throw new UnknownFileTypeException("Unknown file type : " + filePath);
        }

        return separatorIndex;
    }
}
