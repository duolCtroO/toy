package oort.cloud.bank.analyzer;

import oort.cloud.bank.data.BankTransaction;
import oort.cloud.bank.parser.BankStatementCSVParser;
import oort.cloud.bank.parser.BankStatementParser;
import oort.cloud.bank.processor.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }
    public static void collectSummary(final BankStatementProcessor processor){
        System.out.println("Total transaction Amount : " + processor.calculateTotalAmount());
        System.out.println("Total transaction in January : " + processor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Total transaction salary received  : " + processor.calculateTotalForCategory("Salary"));
        System.out.println("Total transaction in January Max Amount  : " + processor.calculateMaxAmountInMonth(Month.JANUARY));
        System.out.println("Total transaction in January Min Amount  : " + processor.calculateMinAmountInMonth(Month.JANUARY));
    }

}
