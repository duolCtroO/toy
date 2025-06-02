package oort.cloud.bank.parser;

import oort.cloud.bank.data.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser{
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_TIME_FORMATTER);
        final double amount = Double.parseDouble(columns[1]);
        final String desc = columns[2];

        return new BankTransaction(date, amount, desc);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactionList = new ArrayList<>();
        for (final String line : lines) {
            bankTransactionList.add(parseFrom(line));
        }
        return bankTransactionList;
    }
}
