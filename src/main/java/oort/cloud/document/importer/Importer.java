package oort.cloud.document.importer;

import oort.cloud.document.domain.Document;

import java.io.File;
import java.io.IOException;

/**
 *  문서를 읽어오는 역할
 */
public interface Importer {
    Document importFile(File file) throws IOException;
}
