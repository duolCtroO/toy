package oort.cloud.bank.analyzer;

import oort.cloud.bank.data.BankTransaction;
import oort.cloud.bank.parser.BankStatementCSVParser;
import oort.cloud.bank.processor.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimpleV3 {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        BankStatementCSVParser parser = new BankStatementCSVParser();
        List<BankTransaction> bankTransactionList = parser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactionList);
        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(final BankStatementProcessor processor){
        System.out.println("Total transaction Amount : " + processor.calculateTotalAmount());
        System.out.println("Total transaction in January : " + processor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Total transaction salary received  : " + processor.calculateTotalForCategory("Salary"));
    }
}
