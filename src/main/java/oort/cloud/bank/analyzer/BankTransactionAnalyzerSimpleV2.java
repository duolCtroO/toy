package oort.cloud.bank.analyzer;

import oort.cloud.bank.data.BankTransaction;
import oort.cloud.bank.parser.BankStatementCSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimpleV2 {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        BankStatementCSVParser parser = new BankStatementCSVParser();
        List<BankTransaction> bankTransactionList = parser.parseLinesFrom(lines);

        System.out.println("total transactions amount : " + calcTotalAmount(bankTransactionList));
        System.out.println("Transactions in January " + selectInMonth(bankTransactionList, Month.JANUARY));
    }

    public static double calcTotalAmount(final List<BankTransaction> bankTransactions){
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> transactions, final Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if(transaction.getDate().getMonth() == month){
                bankTransactionsInMonth.add(transaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
