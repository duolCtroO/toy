package oort.cloud.bank.data;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private LocalDate date;
    private double amount;
    private String desc;
    public BankTransaction(LocalDate date, double amount, String desc) {
        this.date = date;
        this.amount = amount;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && desc.equals(that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, desc);
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", desc='" + desc + '\'' +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }
}
