package oort.cloud.document;

import oort.cloud.document.domain.Document;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toMap;

public class Query implements Predicate<Document> {
    private final Map<String, String> clauses;

    public Query(Map<String, String> clauses) {
        this.clauses = clauses;
    }

    public static Query parse(String query){
        return new Query(
                Arrays.stream(query.split(","))
                        .map(str -> str.split(":"))
                        .collect(toMap(x -> x[0], x -> x[1]))
        );
    }

    @Override
    public boolean test(Document document) {
        return clauses.entrySet().stream()
                .allMatch(
                        entry ->{
                            String documentValue = document.getAttribute(entry.getKey());
                            String queryValue = entry.getValue();
                            return documentValue != null && documentValue.contains(queryValue);
                        });
    }
}
