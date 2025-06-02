package oort.cloud.bank;

import oort.cloud.bank.analyzer.BankTransactionAnalyzer;
import oort.cloud.bank.parser.BankStatementCSVParser;
import oort.cloud.bank.parser.BankStatementParser;

import java.io.IOException;

public class BankApplication {
    public static void main(String[] args) throws IOException {
        BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();
        BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();
        bankTransactionAnalyzer.analyze("transaction.txt", bankStatementCSVParser);
    }
}
