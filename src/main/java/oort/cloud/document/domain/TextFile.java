package oort.cloud.document.domain;

import oort.cloud.document.importer.Attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class TextFile {
    private Map<String, String> attributes = new HashMap<>();
    private List<String> lines;

    public TextFile(File file) throws IOException {
        attributes.put(Attributes.PATH.getValue(), file.getPath());
        lines = Files.lines(file.toPath()).toList();
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public int addLine(int start, Predicate<String> isEnd, String attributeName){
        StringBuilder sb = new StringBuilder();

        int lineNumber;
        for(lineNumber = start; lineNumber < lines.size(); lineNumber++){
            String line = lines.get(lineNumber);
            if(isEnd.test(line)){
                break;
            }

            sb.append(line);
            sb.append("\n");
        }
        attributes.put(attributeName, sb.toString().trim());
        return lineNumber;
    }

    public void addSuffix(String prefix, String attributeName){
        for(String line : lines){
            if(line.startsWith(prefix)){
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}
