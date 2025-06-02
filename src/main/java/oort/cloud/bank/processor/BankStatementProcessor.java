package oort.cloud.bank.processor;

import oort.cloud.bank.data.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category){
        double total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDesc().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateMaxAmountInMonth(final Month month){
        double max = Double.NEGATIVE_INFINITY;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month){
                max = Math.max(max, bankTransaction.getAmount());
            }
        }
        return max == Double.MIN_VALUE ? 0 : max;
    }

    public double calculateMinAmountInMonth(final Month month){
        double min = Double.MAX_VALUE;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month){
                min = Math.min(min, bankTransaction.getAmount());
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }
}
