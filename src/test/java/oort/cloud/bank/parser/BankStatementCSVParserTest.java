package oort.cloud.bank.parser;

import oort.cloud.bank.data.BankTransaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

public class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine(){
        List<BankTransaction> bankTransactions = statementParser.parseLinesFrom(List.of("30-01-2017,1000,test"));
        BankTransaction bankTransaction = bankTransactions.get(0);

        Assertions.assertEquals(bankTransaction.getAmount(), 1000);
        Assertions.assertEquals(bankTransaction.getDesc(), "test");
        Assertions.assertEquals(bankTransaction.getDate().getMonth(), Month.JANUARY);
        Assertions.assertEquals(bankTransaction.getDate().getYear(), 2017);
    }

}